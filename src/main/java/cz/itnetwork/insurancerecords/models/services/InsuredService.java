package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import java.util.List;

/**
 * Interface defining service-layer operations for handling insureds.
 * This abstraction allows different implementations and simplifies unit testing.
 */
public interface InsuredService {

    /**
     * Creates a new insured.
     *
     * @param insured DTO containing data for the new insured
     * @return created insured DTO
     */
    InsuredDTO create(InsuredDTO insured);

    /**
     * Retrieves all insureds.
     *
     * @return list of all insureds as DTOs
     */
    List<InsuredDTO> getAll();

    /**
     * Retrieves insured by its ID.
     *
     * @param insuredId ID of the insured
     * @return insured DTO
     */
    InsuredDTO getById(long insuredId);

    /**
     * Updates an existing insured.
     *
     * @param insured DTO with updated data
     */
    void edit(InsuredDTO insured);

    /**
     * Deletes an insured by its ID.
     *
     * @param insuredId ID of the insured to delete
     */
    void remove(long insuredId);

}
