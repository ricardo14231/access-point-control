package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.AccessLevelDTO;
import dio.innovation.accessPointAPI.service.AccessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("accessLevel")
public class AccessLevelController {

    @Autowired
    private AccessLevelService accessLevelService;

    @PostMapping("/create")
    public ResponseEntity<String> createAccessLevel(@RequestBody @Valid AccessLevelDTO accessLevelDTO) {
        String response = accessLevelService.createAccessLevel(accessLevelDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessLevelDTO> findAccessLevelById(@PathVariable Long id) {
        return new ResponseEntity<>(accessLevelService.findAccessLevelById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<AccessLevelDTO>> listAccessLevel() {
        return new ResponseEntity<>(accessLevelService.listAccessLevel(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String>
        updateAccessLevel(@PathVariable Long id, @RequestBody @Valid AccessLevelDTO accessLevelDTO) {

        String response = accessLevelService.updateAccessLevel(id, accessLevelDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccessLevel(@PathVariable Long id) {
        String response = accessLevelService.deleteAccessLevel(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
