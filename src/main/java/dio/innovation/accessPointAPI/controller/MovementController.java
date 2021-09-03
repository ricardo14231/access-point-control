package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.MovementDTO;
import dio.innovation.accessPointAPI.service.MovementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("movement")
@Api("Endpoint movimentação.")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @PostMapping("/create")
    @ApiOperation("Salva uma nova movimentação.")
    public ResponseEntity<String> createMovement(@RequestBody @Valid MovementDTO movementDTO) {
        String response = movementService.createMovement(movementDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna a movimentação por ID.")
    public ResponseEntity<MovementDTO> findMovementById(@PathVariable Long id) {
        return new ResponseEntity<>(movementService.findMovementById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation("Lista todas as movimentações.")
    public ResponseEntity<List<MovementDTO>> listMovement() {
        return new ResponseEntity<>(movementService.listMovement(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza a movimentação.")
    public ResponseEntity<String>
    updateMovement(@PathVariable Long id, @RequestBody @Valid MovementDTO movementDTO) {
        String response = movementService.updateMovement(id, movementDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Deleta a movimentação.")
    public ResponseEntity<String> deleteMovement(@PathVariable Long id) {
        String response = movementService.deleteMovement(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
