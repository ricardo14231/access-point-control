package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.UserDTO;
import dio.innovation.accessPointAPI.exceptions.ElementIdInconsistencyException;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.UserMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.UserModel;
import dio.innovation.accessPointAPI.repository.UserRepository;
import dio.innovation.accessPointAPI.service.Utils.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DisplayName("Testes para o UserService")
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Salva novo usuário com sucesso.")
    void isShouldCheckCreateUser() {
        UserModel expectedUser = UserBuilder.createUserBuilder();
        UserDTO userToSave = userMapper.toDTO(expectedUser);

        Mockito.when(userRepository.save(Mockito.any(UserModel.class))).thenReturn(expectedUser);

        String response = userService.createUser(userToSave);

        Assertions.assertEquals("Usuário salvo(a) com id: 1.", response);
        Assertions.assertNotEquals("Usuário salvo(a) com id: null.", response);
    }

    @Test
    @DisplayName("Lança uma exception ao criar um novo usuário.")
    void isShouldThrowsNullPointExceptionCreateUser() {
        UserModel expectedUser = UserBuilder.createUserBuilder();
        UserDTO userToSave = userMapper.toDTO(expectedUser);

        userToSave.setName(null);

        Assertions.assertThrows(NullPointerException.class, () -> userService.createUser(userToSave));
    }

    @Test
    @DisplayName("Retorna o usuário por ID.")
    void isShouldReturnTheUserByFindId() {
        UserModel userModel = UserBuilder.createUserBuilder();
        UserDTO expectedUser = userMapper.toDTO(userModel);

        Mockito.when(userRepository.findById(userModel.getId())).thenReturn(Optional.of(userModel));

        UserDTO responseUser = userService.findUserById(expectedUser.getId());

        Assertions.assertEquals(expectedUser.getId(), responseUser.getId());
        Assertions.assertEquals(expectedUser.getName(), responseUser.getName());
        Assertions.assertEquals(expectedUser.getCompany(), responseUser.getCompany());
    }

    @Test
    @DisplayName("Retorna exception ElementNotFound de usuário não encontrado.")
    void isShouldReturnMessageUserNotFound() {
        Assertions.assertThrows(ElementNotFoundException.class, () -> userService.findUserById(1L));
    }

    @Test
    @DisplayName("Retorna uma lista de usuários.")
    void isShouldReturnListOfUsers() {
        UserModel userModel = UserBuilder.createUserBuilder();
        List<UserDTO> expectedListUser = Collections.singletonList(userMapper.toDTO(userModel));

        Mockito.when(userRepository.findAll()).thenReturn(Collections.singletonList(userModel));

        List<UserDTO> responseListUser = userService.listUser();

        Assertions.assertArrayEquals(expectedListUser.toArray(), responseListUser.toArray());
    }

    @Test
    @DisplayName("Retorna uma lista vazia de usuários.")
    void isShouldReturnListEmptyOfUsers() {
        Mockito.when(userRepository.findAll()).thenReturn(Collections.emptyList());

        List<UserDTO> responseListUser = userService.listUser();
        Assertions.assertTrue(responseListUser.isEmpty());
    }

    @Test
    @DisplayName("Atualiza o usuário.")
    void isShouldReturnSucessfulToUpdateUser() {
        UserModel userToUpdate = UserBuilder.createUserBuilder();
        userToUpdate.setName("User name 2");
        UserDTO expectedUser = userMapper.toDTO(userToUpdate);

        Mockito.when(userRepository.findById(userToUpdate.getId())).thenReturn(Optional.of(userToUpdate));
        Mockito.when(userRepository.save(Mockito.any(UserModel.class))).thenReturn(userToUpdate);

        String responseUpdate = userService.updateUser(userToUpdate.getId(), expectedUser);

        Assertions.assertEquals(
                MessageResponse.messageObjUpdate(expectedUser.getId(), "Usuário"), responseUpdate);
        Assertions.assertTrue(responseUpdate.contains(userToUpdate.getId().toString()));
    }

    @Test
    @DisplayName("Retorna exception ElementNotFound ao atualizar o usuário.")
    void isShouldReturnExceptionElementNotFoundToUserUpdate() {
        UserDTO userDTO = userMapper.toDTO(UserBuilder.createUserBuilder());
        Assertions.assertThrows(ElementNotFoundException.class, () -> userService.updateUser(userDTO.getId(), userDTO));
    }

    @Test
    @DisplayName("Restorna insconsistência do Id do parâmetro e do JSON ao atualizar o usuário.")
    void isShouldReturnExceptionElementIdInconsistencyToUserUpdate() {
        UserModel expectedUser = UserBuilder.createUserBuilder();
        UserDTO userToUpdate = userMapper.toDTO(expectedUser);

        Mockito.when(userRepository.findById(expectedUser.getId() + 1)).thenReturn(Optional.of(expectedUser));

        Assertions.assertThrows(ElementIdInconsistencyException.class,
                () -> userService.updateUser(userToUpdate.getId() + 1, userToUpdate));
    }

    @Test
    @DisplayName("Retorna a mensagem de usuário deleteado com sucesso.")
    void isShouldReturnMessageSucessfulUserDelete() {
        UserModel userToDelete = UserBuilder.createUserBuilder();

        Mockito.when(userRepository.findById(userToDelete.getId())).thenReturn(Optional.of(userToDelete));

        String responseDelete = userService.deleteUser(userToDelete.getId());

        Assertions.assertEquals(
                MessageResponse.messageObjDelete(userToDelete.getId(), "Usuário"), responseDelete);
    }

    @Test
    @DisplayName("Retorna a mensagem de usuário não encontrato no método deletar.")
    void isShouldReturnExceptionElementNotFoundToUserDelete() {
        Mockito.doNothing().when(userRepository).deleteById(Mockito.anyLong());

        Assertions.assertThrows(ElementNotFoundException.class, () -> userService.deleteUser(1L));
    }
}