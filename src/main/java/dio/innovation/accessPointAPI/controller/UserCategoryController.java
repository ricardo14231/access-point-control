package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.UserCategoryDTO;
import dio.innovation.accessPointAPI.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("userCategory")
public class UserCategoryController {

    @Autowired
    private UserCategoryService userCategoryService;

    @PostMapping("/create")
    public ResponseEntity<String> createUserCategory(@RequestBody @Valid UserCategoryDTO userCategoryDTO) {
        String response = userCategoryService.createUserCategory(userCategoryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCategoryDTO> findUserCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(userCategoryService.findUserCategoryById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserCategoryDTO>> createUserCategory() {
        return new ResponseEntity<>(userCategoryService.listUserCategory(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> createUserCategory(@PathVariable Long id, @RequestBody @Valid UserCategoryDTO userCategoryDTO) {
        String response = userCategoryService.updateUserCategory(id, userCategoryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserCategory(@PathVariable Long id) {
        String response = userCategoryService.deleteUserCategory(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
