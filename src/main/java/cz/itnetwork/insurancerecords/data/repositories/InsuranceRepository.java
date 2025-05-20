package cz.itnetwork.insurancerecords.data.repositories;

import cz.itnetwork.insurancerecords.data.entities.InsuranceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repository interface for accessing and managing InsuranceEntity records in the database.
 * Provides basic CRUD operations inherited from CrudRepository.
 * Includes a custom query method to find all insurance records by the ID of the associated insured person.
 */
public interface InsuranceRepository extends CrudRepository<InsuranceEntity, Long> {

    /**
     * Finds all insurances that belong to a given insured person.
     *
     * @param insuredId ID of the insured person
     * @return list of insurances associated with the given insured ID
     */
    List<InsuranceEntity> findByInsuredInsuredId(Long insuredId);


}
