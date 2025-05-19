package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;

import java.util.List;

public interface InsuranceService {

    void create(InsuranceDTO insurance);

    List<InsuranceDTO> getAll();

    InsuranceDTO getById(long insuranceId);

}
