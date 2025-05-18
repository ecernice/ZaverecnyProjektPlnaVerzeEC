package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.data.entities.IncidentEntity;
import cz.itnetwork.insurancerecords.data.repositories.IncidentRepository;
import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;
import cz.itnetwork.insurancerecords.models.dto.mappers.IncidentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private IncidentMapper incidentMapper;

    @Override
    public void create(IncidentDTO incident) {
        IncidentEntity newIncident = incidentMapper.toEntity(incident);

        incidentRepository.save(newIncident);
    }

}
