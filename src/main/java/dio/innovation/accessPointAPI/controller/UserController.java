package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.UserDTO;
import dio.innovation.accessPointAPI.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api("Endpoint usuário.")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    @ApiOperation("Salva um usuário.")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserDTO userDTO) {
        String response = userService.createUser(userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna o usuário por ID.")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation("Lista todos os usuário.")
    public ResponseEntity<List<UserDTO>> listUser() {
        return new ResponseEntity<>(userService.listUser(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza o usuário.")
    public ResponseEntity<String>
    updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO) {

        String response = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Deleta o usuário.")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String response = userService.deleteUser(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
