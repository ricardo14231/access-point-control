package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.WorkDayDTO;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.service.WorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("workDay")
public class WorkDayController {

    @Autowired
    private WorkDayService workDayService;

    @PostMapping("/create")
    public ResponseEntity<String> createWorkDay(@RequestBody @Valid WorkDayDTO workDayDTO) {
        try {
            String response = workDayService.createWorkDay(workDayDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkDayDTO> findWorkDayById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(workDayService.findWorkDayById(id), HttpStatus.OK);
        }catch (ElementNotFoundException err) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<WorkDayDTO>> listAllWorkDay() {
        try {
            return new ResponseEntity<>(workDayService.listAllWorkDay(), HttpStatus.OK);
        }catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateWorkDay(@PathVariable Long id, @RequestBody @Valid WorkDayDTO workDayDTO) {
        try {
            String response = workDayService.updateWorkDay(id, workDayDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWorkDay(@PathVariable Long id) {
        try {
            String response = workDayService.deleteWorkDay(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (ElementNotFoundException err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
