package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.CompanyDTO;
import dio.innovation.accessPointAPI.service.CompanyService;
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
@RequestMapping("company")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api("Endpoint Empresa.")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/create")
    @ApiOperation("Salva uma nova empresa.")
    public ResponseEntity<String> createCompany(@RequestBody @Valid CompanyDTO companyDTO) {
        String response = companyService.createCompany(companyDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna a empresa por ID.")
    public ResponseEntity<CompanyDTO> findCompanyById(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.findCompanyById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation("Lista todas as empresas.")
    public ResponseEntity<List<CompanyDTO>> listAllCompany() {
        return new ResponseEntity<>(companyService.listAllCompany(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza a empresa.")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody @Valid CompanyDTO companyDTO) {
        String response = companyService.updateCompany(id, companyDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Deleta a empresa.")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        String response = companyService.deleteCompany(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
