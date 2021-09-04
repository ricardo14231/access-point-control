package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.MovementDTO;
import dio.innovation.accessPointAPI.model.MovementModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovementMapper {

    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

    MovementModel toModel(MovementDTO movementDTO);
    MovementModel.IdMovementModel toIdModel(MovementDTO.IdMovementDTO idMovementDTO);

    MovementDTO toDTO(MovementModel movementModel);
    MovementDTO.IdMovementDTO toIdDTO(MovementModel.IdMovementModel idMovementModel);
}
