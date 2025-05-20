package cz.itnetwork.insurancerecords.models.dto.mappers;

import cz.itnetwork.insurancerecords.data.entities.IncidentEntity;
import cz.itnetwork.insurancerecords.models.dto.IncidentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * MapStruct mapper for converting between IncidentEntity and IncidentDTO.
 * This interface is used to separate mapping logic from business logic. It simplifies transformations between the database entities and the data transfer objects used in the service and controller layers.
 * The implementation is generated automatically by MapStruct at compile time.
 *
 */
@Mapper(componentModel = "spring")
public interface IncidentMapper {

    /**
     * Converts an IncidentDTO to an IncidentEntity.
     *
     * @param source the source DTO object
     * @return the mapped Entity object
     */
    IncidentEntity toEntity(IncidentDTO source);

    /**
     * Converts an IncidentEntity to an IncidentDTO.
     *
     * @param source the source Entity object
     * @return the mapped DTO object
     */
    IncidentDTO toDTO(IncidentEntity source);

    /**
     * Updates an existing IncidentDTO with values from another IncidentDTO.
     * Only fields present in the source object will be copied to the target.
     *
     * @param source the DTO containing updated values
     * @param target the DTO to be updated
     */
    void updateIncidentDTO(IncidentDTO source, @MappingTarget IncidentDTO target);

    /**
     * Updates an existing IncidentDTO with values from another IncidentDTO.
     * Only fields present in the source object will be copied to the target.
     *
     * @param source the DTO containing updated values
     * @param target the DTO to be updated
     */
    void updateIncidentEntity(IncidentDTO source, @MappingTarget IncidentEntity target);

}
