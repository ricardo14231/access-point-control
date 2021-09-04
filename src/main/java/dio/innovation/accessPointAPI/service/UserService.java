package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.UserDTO;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.UserMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.UserModel;
import dio.innovation.accessPointAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserMapper userMapper = UserMapper.INSTANCE;

    private final UserRepository userRepository;

    public String createUser(UserDTO userDTO) {
        UserModel userToSave = userMapper.toModel(userDTO);
        Long id = userRepository.save(userToSave).getId();

        return MessageResponse.messageObjCreate(id, "Usuário");
    }

    public UserDTO findUserById(Long id) {
        return userMapper.toDTO(verifyIfExists(id));
    }

    public List<UserDTO> listUser() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateUser(Long id, UserDTO userDTO) {

        verifyIfExists(id);
        userRepository.save(userMapper.toModel(userDTO));

        return MessageResponse.messageObjUpdate(id, "Usuário");
    }

    public String deleteUser(Long id) {
        verifyIfExists(id);
        userRepository.deleteById(id);
        return MessageResponse.messageObjDelete(id, "Usuário");
    }

    private UserModel verifyIfExists(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "Usuário"));
    }
}
