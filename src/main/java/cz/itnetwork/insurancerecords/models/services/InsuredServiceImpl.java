package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.data.entities.InsuredEntity;
import cz.itnetwork.insurancerecords.data.repositories.InsuredRepository;
import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import cz.itnetwork.insurancerecords.models.dto.mappers.InsuredMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Implementation of the InsuredService interface.
 * Handles the business logic and interacts with the repository layer.
 */
@Service
public class InsuredServiceImpl implements InsuredService {

    @Autowired
    private InsuredRepository insuredRepository;

    @Autowired
    private InsuredMapper insuredMapper;

    /**
     * Creates a new insured and saves it to the database.
     *
     * @param insured DTO containing data for the new insured
     * @return the saved insured as a DTO
     */
    @Override
    public InsuredDTO create(InsuredDTO insured) {
        InsuredEntity newInsured = insuredMapper.toEntity(insured);

        InsuredEntity saved = insuredRepository.save(newInsured);

        return insuredMapper.toDTO(saved);
    }

    /**
     * Retrieves all insureds from the database and maps them to DTOs.
     *
     * @return list of all insureds
     */
    @Override
    public List<InsuredDTO> getAll() {
        return StreamSupport.stream(insuredRepository.findAll().spliterator(), false)
                .map(i -> insuredMapper.toDTO(i))
                .toList();
    }

    /**
     * Retrieves an insured by its ID.
     *
     * @param insuredId ID of the insured
     * @return DTO representing the insured
     */
    @Override
    public InsuredDTO getById(long insuredId) {
        InsuredEntity fetchedInsured = getInsuredOrThrow(insuredId);

        return insuredMapper.toDTO(fetchedInsured);
    }

    /**
     * Updates an existing insured with new data.
     *
     * @param insured DTO with updated data
     */
    @Override
    public void edit(InsuredDTO insured) {
        InsuredEntity fetchedInsured = getInsuredOrThrow(insured.getInsuredId());

        insuredMapper.updateInsuredEntity(insured, fetchedInsured);
        insuredRepository.save(fetchedInsured);
    }

    /**
     * Deletes an insured by its ID.
     *
     * @param insuredId ID of the insured to delete
     */
    @Override
    public void remove(long insuredId) {
        InsuredEntity fetchedInsured = getInsuredOrThrow(insuredId);
        insuredRepository.delete(fetchedInsured);
    }

    /**
     * Helper method for retrieving an insured by ID or throwing an exception.
     *
     * @param insuredId ID of the insured
     * @return the found InsuredEntity
     */
    private InsuredEntity getInsuredOrThrow(long insuredId) {
        return insuredRepository
                .findById(insuredId)
                .orElseThrow();
    }

}
