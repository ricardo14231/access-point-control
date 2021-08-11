package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.OccurrenceDTO;
import dio.innovation.accessPointAPI.model.OccurrenceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OccurrenceMapper {

    OccurrenceMapper INSTANCE = Mappers.getMapper(OccurrenceMapper.class);

    OccurrenceModel toModel(OccurrenceDTO occurrenceDTO);

    OccurrenceDTO toDTO(OccurrenceModel occurrenceModel);
}
