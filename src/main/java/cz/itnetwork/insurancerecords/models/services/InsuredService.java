package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import java.util.List;

public interface InsuredService {

    InsuredDTO create(InsuredDTO insured);

    List<InsuredDTO> getAll();

    InsuredDTO getById(long insuredId);

    void edit(InsuredDTO insured);

}
