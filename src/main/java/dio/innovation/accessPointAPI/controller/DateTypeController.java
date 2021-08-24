package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.DateTypeDTO;
import dio.innovation.accessPointAPI.service.DateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("datetype")
public class DateTypeController {

    @Autowired
    private DateTypeService dateTypeService;

    @PostMapping("/create")
    public ResponseEntity<String> createDateType(@RequestBody @Valid DateTypeDTO dateTypeDTO) {
        String response = dateTypeService.createDateType(dateTypeDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DateTypeDTO> findDateTypeById(@PathVariable Long id) {
        return new ResponseEntity<>(dateTypeService.findDateTypeById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<DateTypeDTO>> listDateType() {
        return new ResponseEntity<>(dateTypeService.listDateType(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String>
    updateDateType(@PathVariable Long id, @RequestBody @Valid DateTypeDTO dateTypeDTO) {

        String response = dateTypeService.updateDateType(id, dateTypeDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDateType(@PathVariable Long id) {
        String response = dateTypeService.deleteDateType(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
