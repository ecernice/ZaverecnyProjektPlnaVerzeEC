package cz.itnetwork.insurancerecords.data.repositories;

import cz.itnetwork.insurancerecords.data.entities.IncidentEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for accessing and managing IncidentEntity records in the database.
 * Provides basic CRUD operations inherited from CrudRepository.
 */
public interface IncidentRepository extends CrudRepository<IncidentEntity, Long> {
}
