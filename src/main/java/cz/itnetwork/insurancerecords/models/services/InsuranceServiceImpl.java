package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.data.entities.InsuranceEntity;
import cz.itnetwork.insurancerecords.data.entities.InsuredEntity;
import cz.itnetwork.insurancerecords.data.repositories.InsuranceRepository;
import cz.itnetwork.insurancerecords.data.repositories.InsuredRepository;
import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import cz.itnetwork.insurancerecords.models.dto.mappers.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Implementation of the InsuranceService interface.
 * Handles the business logic and interacts with the repository layer.
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private InsuredRepository insuredRepository;

    @Autowired
    private InsuranceMapper insuranceMapper;

    /**
     * Creates a new insurance and saves it to the database.
     * Ensures that the associated insured exists.
     *
     * @param insurance DTO containing data for the new insurance
     * @return the saved insurance as a DTO
     */
    @Override
    public InsuranceDTO create(InsuranceDTO insurance) {
        InsuranceEntity newInsurance = insuranceMapper.toEntity(insurance);
        InsuredEntity insured = insuredRepository.findById(insurance.getInsuredId())
                .orElseThrow(() -> new IllegalArgumentException("Pojištěnec s ID " + insurance.getInsuredId() + " nenalezen"));
        newInsurance.setInsured(insured);

        InsuranceEntity saved = insuranceRepository.save(newInsurance);

        return insuranceMapper.toDTO(saved);
    }

    /**
     * Retrieves all insurances from the database and maps them to DTOs.
     *
     * @return list of all insurances
     */
    @Override
    public List<InsuranceDTO> getAll() {
        return StreamSupport.stream(insuranceRepository.findAll().spliterator(), false)
                .map(i -> insuranceMapper.toDTO(i))
                .toList();
    }

    /**
     * Retrieves an insurance by its ID.
     *
     * @param insuranceId ID of the insurance
     * @return DTO representing the insurance
     */
    @Override
    public InsuranceDTO getById(long insuranceId) {
        InsuranceEntity fetchedInsurance = getInsuranceOrThrow(insuranceId);
        return insuranceMapper.toDTO(fetchedInsurance);

    }

    /**
     * Retrieves the insurance by its insureds (foreign key) ID.
     *
     * @param insuredId ID of the insured connected to the insurance
     * @return list of insurances connected to specific insured
     */
    @Override
    public List<InsuranceDTO> getByInsuredId(long insuredId) {
        return StreamSupport.stream(insuranceRepository.findByInsuredInsuredId(insuredId).spliterator(), false)
                .map(i -> insuranceMapper.toDTO(i))
                .toList();
    }

    /**
     * Updates an existing insurance with new data.
     *
     * @param insurance DTO with updated data
     */
    @Override
    public void edit(InsuranceDTO insurance) {
        InsuranceEntity fetchedInsurance = getInsuranceOrThrow(insurance.getInsuranceId());

        insuranceMapper.updateInsuranceEntity(insurance, fetchedInsurance);
        insuranceRepository.save(fetchedInsurance);
    }

    /**
     * Deletes an insurance by its ID.
     *
     * @param insuranceId ID of the insurance to delete
     */
    @Override
    public void remove(long insuranceId) {
        InsuranceEntity fetchedInsurance = getInsuranceOrThrow(insuranceId);
        insuranceRepository.delete(fetchedInsurance);
    }

    /**
     * Helper method for retrieving an insurance by ID or throwing an exception.
     *
     * @param insuranceId ID of the insurance
     * @return the found InsuranceEntity
     */
    private InsuranceEntity getInsuranceOrThrow(long insuranceId) {
        return insuranceRepository
                .findById(insuranceId)
                .orElseThrow();
    }

}
