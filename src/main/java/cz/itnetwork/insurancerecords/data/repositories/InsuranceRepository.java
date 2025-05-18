package cz.itnetwork.insurancerecords.data.repositories;

import cz.itnetwork.insurancerecords.data.entities.InsuranceEntity;
import org.springframework.data.repository.CrudRepository;

public interface InsuranceRepository extends CrudRepository<InsuranceEntity, Long> {
}
