package cz.itnetwork.insurancerecords.models.dto.mappers;

import cz.itnetwork.insurancerecords.data.entities.InsuranceEntity;
import cz.itnetwork.insurancerecords.models.dto.InsuranceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper interface for converting between InsuranceEntity and InsuranceDTO.
 * This interface defines mapping rules used by MapStruct to automate the conversion between entity and DTO representations of insurance data.
 * It also supports partial updates of DTOs and entities.
 */
@Mapper(componentModel = "spring")
public interface InsuranceMapper {

    /**
     * Converts a DTO to a corresponding entity.
     *
     * @param source The DTO to convert.
     * @return The resulting entity.
     */
    InsuranceEntity toEntity(InsuranceDTO source);

    /**
     * Converts an entity to a corresponding DTO.
     *
     * @param source The entity to convert.
     * @return The resulting DTO.
     */
    InsuranceDTO toDTO(InsuranceEntity source);

    /**
     * Updates an existing DTO using data from another DTO.
     *
     * @param source The source DTO containing updated values.
     * @param target The target DTO to be updated.
     */
    void updateInsuranceDTO(InsuranceDTO source, @MappingTarget InsuranceDTO target);

    /**
     * Updates an existing entity using data from a DTO.
     *
     * @param source The DTO containing updated values.
     * @param target The target entity to be updated.
     */
    void updateInsuranceEntity(InsuranceDTO source, @MappingTarget InsuranceEntity target);

}
