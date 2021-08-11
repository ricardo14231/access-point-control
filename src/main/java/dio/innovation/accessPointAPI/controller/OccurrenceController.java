package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.OccurrenceDTO;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.service.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("occurrence")
public class OccurrenceController {

    @Autowired
    private OccurrenceService occurrenceService;

    @PostMapping("/create")
    public ResponseEntity<String> createOccurrence(@RequestBody @Valid OccurrenceDTO occurrenceDTO) {
        try {
            String response = occurrenceService.createOccurrence(occurrenceDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OccurrenceDTO> findOccurrenceById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(occurrenceService.findOccurenceById(id), HttpStatus.OK);
        }catch (ElementNotFoundException err) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<OccurrenceDTO>> listAllOccurrence() {
        try {
            return new ResponseEntity<>(occurrenceService.listAllOccurrence(), HttpStatus.OK);
        }catch (ElementNotFoundException err) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOccurrence(@PathVariable Long id, @RequestBody @Valid OccurrenceDTO occurrenceDTO) {
        try {
            String response = occurrenceService.updateOccurrence(id, occurrenceDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOccurrence(@PathVariable Long id) {
        try {
            String response = occurrenceService.deleteOccurrence(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (ElementNotFoundException err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
