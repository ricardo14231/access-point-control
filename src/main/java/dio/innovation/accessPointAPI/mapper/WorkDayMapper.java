package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.WorkDayDTO;
import dio.innovation.accessPointAPI.model.WorkDayModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkDayMapper {

    WorkDayMapper INSTANCE = Mappers.getMapper(WorkDayMapper.class);

    WorkDayModel toModel(WorkDayDTO workDayDTO);

    WorkDayDTO toDTO(WorkDayModel workDayModel);
}
