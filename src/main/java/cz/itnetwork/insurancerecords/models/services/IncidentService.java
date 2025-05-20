package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;
import java.util.List;

/**
 * Interface defining service-layer operations for handling insurance incidents.
 * This abstraction allows different implementations and simplifies unit testing.
 */
public interface IncidentService {

    /**
     * Creates a new insurance incident.
     *
     * @param incident DTO containing data for the new incident
     * @return created incident DTO
     */
    IncidentDTO create(IncidentDTO incident);

    /**
     * Retrieves all insurance incidents.
     *
     * @return list of all incidents as DTOs
     */
    List<IncidentDTO> getAll();

    /**
     * Retrieves an insurance incident by its ID.
     *
     * @param incidentId ID of the incident
     * @return incident DTO
     */
    IncidentDTO getById(long incidentId);

    /**
     * Updates an existing insurance incident.
     *
     * @param incident DTO with updated data
     */
    void edit(IncidentDTO incident);

    /**
     * Deletes an insurance incident by its ID.
     *
     * @param incidentId ID of the incident to delete
     */
    void remove(long incidentId);

}

