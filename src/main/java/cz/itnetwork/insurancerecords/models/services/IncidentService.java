package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;

public interface IncidentService {

    void create(IncidentDTO incident);

}
