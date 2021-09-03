package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.BankHoursDTO;
import dio.innovation.accessPointAPI.model.BankHoursModel;
import dio.innovation.accessPointAPI.service.BankHoursService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bankHours")
@Api("Endpoint Banco de horas.")
public class BankHoursController {

    @Autowired
    private BankHoursService bankHoursService;

    @PostMapping("/create")
    @ApiOperation("Salva um novo banco de horas.")
    public ResponseEntity<String> createBankHours(@RequestBody @Valid BankHoursDTO bankHoursDTO) {
        String response = bankHoursService.createBankHours(bankHoursDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findById")
    @ApiOperation("Retorna o banco de horas por ID.")
    public ResponseEntity<BankHoursDTO> findBankHoursById(@RequestBody BankHoursModel.IdBankHoursModel id) {
        return new ResponseEntity<>(bankHoursService.findBankHoursById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation("Lista o banco de horas.")
    public ResponseEntity<List<BankHoursDTO>> listBankHours() {
        return new ResponseEntity<>(bankHoursService.listBankHours(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza o banco de horas.")
    public ResponseEntity<String>
    updateBankHours(@PathVariable BankHoursModel.IdBankHoursModel id, @RequestBody @Valid BankHoursDTO bankHoursDTO) {

        String response = bankHoursService.updateBankHours(id, bankHoursDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ApiOperation("Deleta o banco de horas.")
    public ResponseEntity<String> deleteBankHours(@RequestBody BankHoursModel.IdBankHoursModel id) {
        String response = bankHoursService.deleteBankHours(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
