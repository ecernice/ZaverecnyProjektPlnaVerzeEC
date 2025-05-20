package cz.itnetwork.insurancerecords.models.services;

import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;

import java.util.List;

public interface InsuranceService {

    InsuranceDTO create(InsuranceDTO insurance);

    List<InsuranceDTO> getAll();

    InsuranceDTO getById(long insuranceId);

    List<InsuranceDTO> getByInsuredId(long insuredId);

}
