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

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private InsuredRepository insuredRepository;

    @Autowired
    private InsuranceMapper insuranceMapper;

    @Override
    public void create(InsuranceDTO insurance) {
        InsuranceEntity newInsurance = insuranceMapper.toEntity(insurance);
        InsuredEntity insured = insuredRepository.findById(insurance.getInsuredId())
                .orElseThrow(() -> new IllegalArgumentException("Pojištěnec s ID " + insurance.getInsuredId() + " nenalezen"));
        newInsurance.setInsured(insured);
        insuranceRepository.save(newInsurance);
    }

    @Override
    public List<InsuranceDTO> getAll() {
        return StreamSupport.stream(insuranceRepository.findAll().spliterator(), false)
                .map(i -> insuranceMapper.toDTO(i))
                .toList();
    }

    @Override
    public InsuranceDTO getById(long insuranceId) {
        InsuranceEntity fetchedInsurance = insuranceRepository
                .findById(insuranceId)
                .orElseThrow();
        return insuranceMapper.toDTO(fetchedInsurance);

    }

    @Override
    public List<InsuranceDTO> getByInsuredId(long insuredId) {
        return StreamSupport.stream(insuranceRepository.findByInsuredInsuredId(insuredId).spliterator(), false)
                .map(i -> insuranceMapper.toDTO(i))
                .toList();
    }

}
