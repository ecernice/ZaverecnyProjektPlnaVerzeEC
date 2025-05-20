package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.data.entities.IncidentEntity;
import cz.itnetwork.insurancerecords.data.entities.InsuranceEntity;
import cz.itnetwork.insurancerecords.data.repositories.IncidentRepository;
import cz.itnetwork.insurancerecords.data.repositories.InsuranceRepository;
import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;
import cz.itnetwork.insurancerecords.models.dto.mappers.IncidentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private IncidentMapper incidentMapper;

    @Override
    public IncidentDTO create(IncidentDTO incident) {
        IncidentEntity newIncident = incidentMapper.toEntity(incident);
        InsuranceEntity insurance = insuranceRepository.findById(incident.getInsuranceId())
                        .orElseThrow(() -> new IllegalArgumentException("Pojištění s ID" + incident.getInsuranceId() + " nenalezeno"));
        newIncident.setInsurance(insurance);

        IncidentEntity saved = incidentRepository.save(newIncident);

        return incidentMapper.toDTO(saved);
    }

    @Override
    public List<IncidentDTO> getAll() {
        return StreamSupport.stream(incidentRepository.findAll().spliterator(), false)
                .map(i -> incidentMapper.toDTO(i))
                .toList();
    }

    @Override
    public IncidentDTO getById(long incidentId) {
        IncidentEntity fetchedIncident = incidentRepository
                .findById(incidentId)
                .orElseThrow();
        return incidentMapper.toDTO(fetchedIncident);
    }

}
