package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.DateTypeDTO;
import dio.innovation.accessPointAPI.model.DateTypeModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DateTypeMapper {

    DateTypeMapper INSTANCE = Mappers.getMapper(DateTypeMapper.class);

    DateTypeModel toModel(DateTypeDTO dateTypeDTO);

    DateTypeDTO toDTO(DateTypeModel dateTypeModel);
}
