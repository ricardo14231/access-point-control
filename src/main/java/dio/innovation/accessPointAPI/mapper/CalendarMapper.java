package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.CalendarDTO;
import dio.innovation.accessPointAPI.model.CalendarModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CalendarMapper {

    CalendarMapper INSTANCE = Mappers.getMapper(CalendarMapper.class);

    CalendarModel toModel(CalendarDTO calendarDTO);

    CalendarDTO toDTO(CalendarModel calendarModel);
}
