package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.UserCategoryDTO;
import dio.innovation.accessPointAPI.service.UserCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("userCategory")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api("Endpoint categoria do usuário.")
public class UserCategoryController {

    private final UserCategoryService userCategoryService;

    @PostMapping("/create")
    @ApiOperation("Salva uma nova categoria.")
    public ResponseEntity<String> createUserCategory(@RequestBody @Valid UserCategoryDTO userCategoryDTO) {
        String response = userCategoryService.createUserCategory(userCategoryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna a categoria por ID.")
    public ResponseEntity<UserCategoryDTO> findUserCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(userCategoryService.findUserCategoryById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation("Lista todos as categorias.")
    public ResponseEntity<List<UserCategoryDTO>> createUserCategory() {
        return new ResponseEntity<>(userCategoryService.listUserCategory(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza a categoria.")
    public ResponseEntity<String> createUserCategory(@PathVariable Long id, @RequestBody @Valid UserCategoryDTO userCategoryDTO) {
        String response = userCategoryService.updateUserCategory(id, userCategoryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Deleta a categoria.")
    public ResponseEntity<String> deleteUserCategory(@PathVariable Long id) {
        String response = userCategoryService.deleteUserCategory(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
