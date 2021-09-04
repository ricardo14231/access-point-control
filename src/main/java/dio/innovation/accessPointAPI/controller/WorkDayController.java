package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.WorkDayDTO;
import dio.innovation.accessPointAPI.exceptions.ElementIdInconsistencyException;
import dio.innovation.accessPointAPI.service.WorkDayService;
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
@RequestMapping("workDay")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api("Endpoint jornada de trabalho.")
public class WorkDayController {

    private final WorkDayService workDayService;

    @PostMapping("/create")
    @ApiOperation("Salva uma nova jornada.")
    public ResponseEntity<String> createWorkDay(@RequestBody @Valid WorkDayDTO workDayDTO) {
        String response = workDayService.createWorkDay(workDayDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna a jornada por ID.")
    public ResponseEntity<WorkDayDTO> findWorkDayById(@PathVariable Long id) {
        return new ResponseEntity<>(workDayService.findWorkDayById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation("Lista todas as jornadas.")
    public ResponseEntity<List<WorkDayDTO>> listAllWorkDay() {
        return new ResponseEntity<>(workDayService.listAllWorkDay(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza a jornada.")
    public ResponseEntity<String> updateWorkDay(@PathVariable Long id, @RequestBody @Valid WorkDayDTO workDayDTO) {
        String response = workDayService.updateWorkDay(id, workDayDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Deleta a jornada.")
    public ResponseEntity<String> deleteWorkDay(@PathVariable Long id) {
        String response = workDayService.deleteWorkDay(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
