package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import java.util.List;

public interface InsuredService {

    void create(InsuredDTO insured);

    List<InsuredDTO> getAll();

}
