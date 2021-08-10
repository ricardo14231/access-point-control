package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.CompanyDTO;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<String> createCompany(@RequestBody @Valid CompanyDTO companyDTO) {
       try {
            String response = companyService.createCompany(companyDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
       }catch (Exception err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findCompanyById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(companyService.findCompanyById(id), HttpStatus.OK);
        }catch (ElementNotFoundException err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CompanyDTO>> listAllCompany() {
        try {
            return new ResponseEntity<>(companyService.listAllCompany(), HttpStatus.OK);
        }catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody @Valid CompanyDTO companyDTO) {
        try {
            String response = companyService.updateCompany(id, companyDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        try {
            String response = companyService.deleteCompany(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
