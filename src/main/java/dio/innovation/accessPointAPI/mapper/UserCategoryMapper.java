package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.UserCategoryDTO;
import dio.innovation.accessPointAPI.model.UserCategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserCategoryMapper {

    UserCategoryMapper INSTANCE = Mappers.getMapper(UserCategoryMapper.class);

    UserCategoryModel toModel(UserCategoryDTO userCategoryDTO);

    UserCategoryDTO toDTO(UserCategoryModel userCategoryModel);
}
