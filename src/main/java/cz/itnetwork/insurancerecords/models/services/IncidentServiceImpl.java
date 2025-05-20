package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.data.entities.IncidentEntity;
import cz.itnetwork.insurancerecords.data.entities.InsuranceEntity;
import cz.itnetwork.insurancerecords.data.entities.InsuredEntity;
import cz.itnetwork.insurancerecords.data.repositories.IncidentRepository;
import cz.itnetwork.insurancerecords.data.repositories.InsuranceRepository;
import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;
import cz.itnetwork.insurancerecords.models.dto.mappers.IncidentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Implementation of the IncidentService interface.
 * Handles the business logic and interacts with the repository layer.
 */
@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private IncidentMapper incidentMapper;

    /**
     * Creates a new insurance incident and saves it to the database.
     * Ensures that the associated insurance exists.
     *
     * @param incident DTO containing data for the new incident
     * @return the saved incident as a DTO
     */
    @Override
    public IncidentDTO create(IncidentDTO incident) {
        IncidentEntity newIncident = incidentMapper.toEntity(incident);
        InsuranceEntity insurance = insuranceRepository.findById(incident.getInsuranceId())
                        .orElseThrow(() -> new IllegalArgumentException("Pojištění s ID" + incident.getInsuranceId() + " nenalezeno"));
        newIncident.setInsurance(insurance);

        IncidentEntity saved = incidentRepository.save(newIncident);

        return incidentMapper.toDTO(saved);
    }

    /**
     * Retrieves all incidents from the database and maps them to DTOs.
     *
     * @return list of all incidents
     */
    @Override
    public List<IncidentDTO> getAll() {
        return StreamSupport.stream(incidentRepository.findAll().spliterator(), false)
                .map(i -> incidentMapper.toDTO(i))
                .toList();
    }

    /**
     * Retrieves an incident by its ID.
     *
     * @param incidentId ID of the incident
     * @return DTO representing the incident
     */
    @Override
    public IncidentDTO getById(long incidentId) {
        IncidentEntity fetchedIncident = getIncidentOrThrow(incidentId);
        return incidentMapper.toDTO(fetchedIncident);
    }

    /**
     * Updates an existing incident with new data.
     *
     * @param incident DTO with updated data
     */
    @Override
    public void edit(IncidentDTO incident) {
        IncidentEntity fetchedIncident = getIncidentOrThrow(incident.getIncidentId());

        incidentMapper.updateIncidentEntity(incident, fetchedIncident);
        incidentRepository.save(fetchedIncident);
    }

    /**
     * Deletes an incident by its ID.
     *
     * @param incidentId ID of the incident to delete
     */
    @Override
    public void remove(long incidentId) {
        IncidentEntity fetchedIncident = getIncidentOrThrow(incidentId);
        incidentRepository.delete(fetchedIncident);
    }

    /**
     * Helper method for retrieving an incident by ID or throwing an exception.
     *
     * @param incidentId ID of the incident
     * @return the found IncidentEntity
     */
    private IncidentEntity getIncidentOrThrow(long incidentId) {
        return incidentRepository
                .findById(incidentId)
                .orElseThrow();
    }
}
