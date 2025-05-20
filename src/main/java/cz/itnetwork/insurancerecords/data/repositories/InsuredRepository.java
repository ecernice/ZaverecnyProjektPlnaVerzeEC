package cz.itnetwork.insurancerecords.data.repositories;

import cz.itnetwork.insurancerecords.data.entities.InsuredEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing and managing InsuredEntity records in the database.
 * Provides basic CRUD operations inherited from CrudRepository.
 */
public interface InsuredRepository extends CrudRepository<InsuredEntity, Long> {
}
