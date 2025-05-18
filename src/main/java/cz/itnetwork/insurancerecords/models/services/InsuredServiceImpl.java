package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.data.entities.InsuredEntity;
import cz.itnetwork.insurancerecords.data.repositories.InsuredRepository;
import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuredServiceImpl implements InsuredService {

    @Autowired
    private InsuredRepository insuredRepository;

    @Override
    public void create(InsuredDTO insured) {
        InsuredEntity newInsured = new InsuredEntity();

        newInsured.setName(insured.getName());
        newInsured.setSurname(insured.getSurname());
        newInsured.setEmail(insured.getEmail());
        newInsured.setPhoneNumber(insured.getPhoneNumber());
        newInsured.setStreet(insured.getStreet());
        newInsured.setCity(insured.getCity());
        newInsured.setZipcode(insured.getZipcode());

        insuredRepository.save(newInsured);
    }

}
