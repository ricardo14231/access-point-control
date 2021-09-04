package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.DateTypeDTO;
import dio.innovation.accessPointAPI.service.DateTypeService;
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
@RequestMapping("datetype")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api("Endpoint tipo de data.")
public class DateTypeController {

    private final DateTypeService dateTypeService;

    @PostMapping("/create")
    @ApiOperation("Salva um novo tipo de data.")
    public ResponseEntity<String> createDateType(@RequestBody @Valid DateTypeDTO dateTypeDTO) {
        String response = dateTypeService.createDateType(dateTypeDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna o tipo de data por ID.")
    public ResponseEntity<DateTypeDTO> findDateTypeById(@PathVariable Long id) {
        return new ResponseEntity<>(dateTypeService.findDateTypeById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation("Lista todos os tipos de datas.")
    public ResponseEntity<List<DateTypeDTO>> listDateType() {
        return new ResponseEntity<>(dateTypeService.listDateType(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza o tipo de data.")
    public ResponseEntity<String>
    updateDateType(@PathVariable Long id, @RequestBody @Valid DateTypeDTO dateTypeDTO) {

        String response = dateTypeService.updateDateType(id, dateTypeDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Deleta o tipo de data.")
    public ResponseEntity<String> deleteDateType(@PathVariable Long id) {
        String response = dateTypeService.deleteDateType(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
