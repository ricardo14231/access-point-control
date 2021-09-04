package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.UserDTO;
import dio.innovation.accessPointAPI.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserModel toModel(UserDTO userDTO);

    UserDTO toDTO(UserModel userModel);
}
