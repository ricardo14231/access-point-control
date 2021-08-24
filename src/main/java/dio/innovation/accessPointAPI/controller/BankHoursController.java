package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.BankHoursDTO;
import dio.innovation.accessPointAPI.service.BankHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bankHours")
public class BankHoursController {

    @Autowired
    private BankHoursService bankHoursService;

    @PostMapping("/create")
    public ResponseEntity<String> createBankHours(@RequestBody @Valid BankHoursDTO bankHoursDTO) {
        String response = bankHoursService.createBankHours(bankHoursDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankHoursDTO> findBankHoursById(@PathVariable Long id) {
        return new ResponseEntity<>(bankHoursService.findBankHoursById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BankHoursDTO>> listBankHours() {
        return new ResponseEntity<>(bankHoursService.listBankHours(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String>
    updateBankHours(@PathVariable Long id, @RequestBody @Valid BankHoursDTO bankHoursDTO) {

        String response = bankHoursService.updateBankHours(id, bankHoursDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBankHours(@PathVariable Long id) {
        String response = bankHoursService.deleteBankHours(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
