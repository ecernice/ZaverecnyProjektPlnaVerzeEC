package cz.itnetwork.insurancerecords.models.dto.mappers;

import cz.itnetwork.insurancerecords.data.entities.InsuredEntity;
import cz.itnetwork.insurancerecords.models.dto.InsuredDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper interface for converting between InsuredEntity and InsuredDTO.
 * This interface uses MapStruct to automatically generate the implementation code.
 * It allows conversion from entity to DTO and vice versa, and also supports partial updates of existing DTOs or entities.
 */
@Mapper(componentModel = "spring")
public interface InsuredMapper {

    /**
     * Converts a DTO to a corresponding entity.
     *
     * @param source The DTO to convert.
     * @return The resulting entity.
     */
    InsuredEntity toEntity(InsuredDTO source);

    /**
     * Converts an entity to a corresponding DTO.
     *
     * @param source The entity to convert.
     * @return The resulting DTO.
     */
    InsuredDTO toDTO(InsuredEntity source);

    /**
     * Updates an existing DTO using data from another DTO.
     *
     * @param source The source DTO containing updated values.
     * @param target The target DTO to be updated.
     */
    void updateInsuredDTO(InsuredDTO source, @MappingTarget InsuredDTO target);

    /**
     * Updates an existing entity using data from a DTO.
     *
     * @param source The DTO containing updated values.
     * @param target The target entity to be updated.
     */
    void updateInsuredEntity(InsuredDTO source, @MappingTarget InsuredEntity target);

}
