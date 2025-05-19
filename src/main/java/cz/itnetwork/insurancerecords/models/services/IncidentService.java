package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;
import java.util.List;

public interface IncidentService {

    void create(IncidentDTO incident);

    List<IncidentDTO> getAll();

}
