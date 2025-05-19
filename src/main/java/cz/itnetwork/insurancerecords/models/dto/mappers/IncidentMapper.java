package cz.itnetwork.insurancerecords.models.dto.mappers;

import cz.itnetwork.insurancerecords.data.entities.IncidentEntity;
import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncidentMapper {

    IncidentEntity toEntity(IncidentDTO source);

    IncidentDTO toDTO(IncidentEntity source);

}
