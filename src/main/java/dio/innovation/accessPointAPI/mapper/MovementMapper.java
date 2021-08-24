package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.MovementDTO;
import dio.innovation.accessPointAPI.model.MovementModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovementMapper {

    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

    MovementModel toModel(MovementDTO movementDTO);

    MovementDTO toDTO(MovementModel movementModel);
}
