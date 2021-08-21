package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.UserCategoryDTO;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userCategory")
public class UserCategoryController {

    @Autowired
    private UserCategoryService userCategoryService;

    @PostMapping("/create")
    public ResponseEntity<String> createUserCategory(@RequestBody UserCategoryDTO userCategoryDTO) {
        try {
            String response = userCategoryService.createUserCategory(userCategoryDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCategoryDTO> findUserCategoryById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(userCategoryService.findUserCategoryById(id), HttpStatus.OK);
        }catch (ElementNotFoundException err) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserCategoryDTO>> createUserCategory() {
        try {
            return new ResponseEntity<>(userCategoryService.listUserCategory(), HttpStatus.OK);
        }catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> createUserCategory(@PathVariable Long id, @RequestBody UserCategoryDTO userCategoryDTO) {
        try {
            String response = userCategoryService.updateUserCategory(id, userCategoryDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserCategory(@PathVariable Long id) {
        try {
            String response = userCategoryService.deleteUserCategory(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (ElementNotFoundException err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
