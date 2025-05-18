package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.data.entities.InsuranceEntity;
import cz.itnetwork.insurancerecords.data.repositories.InsuranceRepository;
import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import cz.itnetwork.insurancerecords.models.dto.mappers.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private InsuranceMapper insuranceMapper;

    @Override
    public void create(InsuranceDTO insurance) {
        InsuranceEntity newInsurance = insuranceMapper.toEntity(insurance);

        insuranceRepository.save(newInsurance);
    }

}
