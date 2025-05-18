package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.data.entities.InsuranceEntity;
import cz.itnetwork.insurancerecords.data.repositories.InsuranceRepository;
import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public void create(InsuranceDTO insurance) {
        InsuranceEntity newInsurance = new InsuranceEntity();

        newInsurance.setInsuranceType(insurance.getInsuranceType());
        newInsurance.setAmount(insurance.getAmount());
        newInsurance.setInsuranceSubject(insurance.getInsuranceSubject());
        newInsurance.setValidFrom(insurance.getValidFrom());
        newInsurance.setValidTo(insurance.getValidTo());

        insuranceRepository.save(newInsurance);
    }

}
