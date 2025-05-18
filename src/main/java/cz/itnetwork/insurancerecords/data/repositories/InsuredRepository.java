package cz.itnetwork.insurancerecords.data.repositories;

import cz.itnetwork.insurancerecords.data.entities.InsuredEntity;
import org.springframework.data.repository.CrudRepository;

public interface InsuredRepository extends CrudRepository<InsuredEntity, Long> {
}
