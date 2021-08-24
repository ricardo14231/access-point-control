package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.AccessLevelDTO;
import dio.innovation.accessPointAPI.model.AccessLevelModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccessLevelMapper {

    AccessLevelMapper INSTANCE = Mappers.getMapper(AccessLevelMapper.class);

    AccessLevelModel toModel(AccessLevelDTO accessLevelDTO);

    AccessLevelDTO toDTO(AccessLevelModel accessLevelModel);
}
