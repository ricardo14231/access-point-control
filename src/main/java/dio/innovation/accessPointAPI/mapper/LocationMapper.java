package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.LocationDTO;
import dio.innovation.accessPointAPI.model.LocationModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    LocationModel toModel(LocationDTO locationDTO);

    LocationDTO toDTO(LocationModel locationModel);
}
