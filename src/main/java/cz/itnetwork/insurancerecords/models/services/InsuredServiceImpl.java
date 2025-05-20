package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.data.entities.InsuredEntity;
import cz.itnetwork.insurancerecords.data.repositories.InsuredRepository;
import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import cz.itnetwork.insurancerecords.models.dto.mappers.InsuredMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class InsuredServiceImpl implements InsuredService {

    @Autowired
    private InsuredRepository insuredRepository;

    @Autowired
    private InsuredMapper insuredMapper;

    @Override
    public InsuredDTO create(InsuredDTO insured) {
        InsuredEntity newInsured = insuredMapper.toEntity(insured);

        InsuredEntity saved = insuredRepository.save(newInsured);

        return insuredMapper.toDTO(saved);
    }

    @Override
    public List<InsuredDTO> getAll() {
        return StreamSupport.stream(insuredRepository.findAll().spliterator(), false)
                .map(i -> insuredMapper.toDTO(i))
                .toList();
    }

    @Override
    public InsuredDTO getById(long insuredId) {
        InsuredEntity fetchedInsured = insuredRepository
                .findById(insuredId)
                .orElseThrow();
        return insuredMapper.toDTO(fetchedInsured);
    }

}
