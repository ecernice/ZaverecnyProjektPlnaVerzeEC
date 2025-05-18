package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.data.entities.IncidentEntity;
import cz.itnetwork.insurancerecords.data.repositories.IncidentRepository;
import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Override
    public void create(IncidentDTO incident) {
        IncidentEntity newIncident = new IncidentEntity();

        newIncident.setTitle(incident.getTitle());
        newIncident.setDescription(incident.getDescription());
        newIncident.setIncidentDate(incident.getIncidentDate());
        newIncident.setInsuranceAmount(incident.getInsuranceAmount());

        incidentRepository.save(newIncident);
    }

}
