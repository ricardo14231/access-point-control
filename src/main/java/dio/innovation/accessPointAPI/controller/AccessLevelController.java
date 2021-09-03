package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.AccessLevelDTO;
import dio.innovation.accessPointAPI.service.AccessLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("accessLevel")
@Api("Endpoint nível de acesso.")
public class AccessLevelController {

    @Autowired
    private AccessLevelService accessLevelService;

    @PostMapping("/create")
    @ApiOperation("Salva um nível de acesso.")
    public ResponseEntity<String> createAccessLevel(@RequestBody @Valid AccessLevelDTO accessLevelDTO) {
        String response = accessLevelService.createAccessLevel(accessLevelDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna o nível de acesso por ID.")
    public ResponseEntity<AccessLevelDTO> findAccessLevelById(@PathVariable Long id) {
        return new ResponseEntity<>(accessLevelService.findAccessLevelById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation("Lista todos os níveis de acesso.")
    public ResponseEntity<List<AccessLevelDTO>> listAccessLevel() {
        return new ResponseEntity<>(accessLevelService.listAccessLevel(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza o nível de acesso.")
    public ResponseEntity<String>
        updateAccessLevel(@PathVariable Long id, @RequestBody @Valid AccessLevelDTO accessLevelDTO) {

        String response = accessLevelService.updateAccessLevel(id, accessLevelDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Deleta o nível de acesso.")
    public ResponseEntity<String> deleteAccessLevel(@PathVariable Long id) {
        String response = accessLevelService.deleteAccessLevel(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
