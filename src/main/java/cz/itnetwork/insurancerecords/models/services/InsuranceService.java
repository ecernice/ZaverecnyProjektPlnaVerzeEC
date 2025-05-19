package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import java.util.List;

public interface InsuranceService {

    void create(InsuranceDTO insurance);

    List<InsuranceDTO> getAll();

}
