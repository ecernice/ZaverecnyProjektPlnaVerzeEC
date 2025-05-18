package cz.itnetwork.insurancerecords.data.repositories;

import cz.itnetwork.insurancerecords.data.entities.IncidentEntity;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<IncidentEntity, Long> {
}
