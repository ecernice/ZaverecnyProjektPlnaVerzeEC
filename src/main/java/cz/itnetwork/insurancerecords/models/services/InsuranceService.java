package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;

import java.util.List;

/**
 * Interface defining service-layer operations for handling insurances.
 * This abstraction allows different implementations and simplifies unit testing.
 */
public interface InsuranceService {

    /**
     * Creates a new insurance.
     *
     * @param insurance DTO containing data for the new insurance
     * @return created insurance DTO
     */
    InsuranceDTO create(InsuranceDTO insurance);

    /**
     * Retrieves all insurances.
     *
     * @return list of all insurances as DTOs
     */
    List<InsuranceDTO> getAll();

    /**
     * Retrieves an insurance by its ID.
     *
     * @param insuranceId ID of the insurance
     * @return insurance DTO
     */
    InsuranceDTO getById(long insuranceId);

    /**
     * Retrieves an insurance by its insureds IDs (foreign key).
     *
     * @param insuredId ID of the insured connected to the insurance
     * @return list of all insurances (as DTO) connected with the specific insured
     */
    List<InsuranceDTO> getByInsuredId(long insuredId);

    /**
     * Updates an existing insurance.
     *
     * @param insurance DTO with updated data
     */
    void edit(InsuranceDTO insurance);

    /**
     * Deletes an insurance by its ID.
     *
     * @param insuranceId ID of the insurance to delete
     */
    void remove(long insuranceId);

}
