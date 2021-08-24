package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.LocationDTO;
import dio.innovation.accessPointAPI.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/create")
    public ResponseEntity<String> createLocation(@RequestBody @Valid LocationDTO locationDTO) {
        String response = locationService.createLocation(locationDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> findLocationById(@PathVariable Long id) {
        return new ResponseEntity<>(locationService.findLocationById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<LocationDTO>> listLocation() {
        return new ResponseEntity<>(locationService.listLocation(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String>
    updateLocation(@PathVariable Long id, @RequestBody @Valid LocationDTO locationDTO) {

        String response = locationService.updateLocation(id, locationDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        String response = locationService.deleteLocation(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
