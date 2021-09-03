package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.OccurrenceDTO;
import dio.innovation.accessPointAPI.service.OccurrenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("occurrence")
@Api("Endpoint ocorrência.")
public class OccurrenceController {

    @Autowired
    private OccurrenceService occurrenceService;

    @PostMapping("/create")
    @ApiOperation("Salva uma nova ocorrência.")
    public ResponseEntity<String> createOccurrence(@RequestBody @Valid OccurrenceDTO occurrenceDTO) {
        String response = occurrenceService.createOccurrence(occurrenceDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna a ocorrência por ID.")
    public ResponseEntity<OccurrenceDTO> findOccurrenceById(@PathVariable Long id) {
        return new ResponseEntity<>(occurrenceService.findOccurenceById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation("Lista todas as ocorrências.")
    public ResponseEntity<List<OccurrenceDTO>> listAllOccurrence() {
        return new ResponseEntity<>(occurrenceService.listAllOccurrence(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza a ocorrência.")
    public ResponseEntity<String> updateOccurrence(@PathVariable Long id, @RequestBody @Valid OccurrenceDTO occurrenceDTO) {
        String response = occurrenceService.updateOccurrence(id, occurrenceDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Deleta a ocorrência.")
    public ResponseEntity<String> deleteOccurrence(@PathVariable Long id) {
        String response = occurrenceService.deleteOccurrence(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
