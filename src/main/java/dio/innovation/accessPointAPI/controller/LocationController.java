package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.LocationDTO;
import dio.innovation.accessPointAPI.service.LocationService;
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
@RequestMapping("location")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api("Endpoint localidade.")
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/create")
    @ApiOperation("Salva uma nova localidade.")
    public ResponseEntity<String> createLocation(@RequestBody @Valid LocationDTO locationDTO) {
        String response = locationService.createLocation(locationDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna a localidade por ID.")
    public ResponseEntity<LocationDTO> findLocationById(@PathVariable Long id) {
        return new ResponseEntity<>(locationService.findLocationById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation("LIsta todas as localidades.")
    public ResponseEntity<List<LocationDTO>> listLocation() {
        return new ResponseEntity<>(locationService.listLocation(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza a localidade.")
    public ResponseEntity<String>
    updateLocation(@PathVariable Long id, @RequestBody @Valid LocationDTO locationDTO) {

        String response = locationService.updateLocation(id, locationDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Deleta a localidade.")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        String response = locationService.deleteLocation(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
