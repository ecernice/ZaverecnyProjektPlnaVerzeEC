package cz.itnetwork.insurancerecords.models.dto.mappers;

import cz.itnetwork.insurancerecords.data.entities.InsuredEntity;
import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InsuredMapper {

    InsuredEntity toEntity(InsuredDTO source);

}
