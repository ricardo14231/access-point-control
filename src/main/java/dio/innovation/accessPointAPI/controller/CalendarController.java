package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.CalendarDTO;
import dio.innovation.accessPointAPI.service.CalendarService;
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
@RequestMapping("calendar")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api("Endpoint calendário.")
public class CalendarController {

    private final CalendarService calendarService;

    @PostMapping("/create")
    @ApiOperation("Salva um calendário.")
    public ResponseEntity<String> createCalendar(@RequestBody @Valid CalendarDTO calendarDTO) {
        String response = calendarService.createCalendar(calendarDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna o calendário por ID.")
    public ResponseEntity<CalendarDTO> findCalendarById(@PathVariable Long id) {
        return new ResponseEntity<>(calendarService.findCalendarById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation("Lista todos os calendários.")
    public ResponseEntity<List<CalendarDTO>> listCalendar() {
        return new ResponseEntity<>(calendarService.listCalendar(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Atualiza o calendário.")
    public ResponseEntity<String>
    updateCalendar(@PathVariable Long id, @RequestBody @Valid CalendarDTO calendarDTO) {

        String response = calendarService.updateCalendar(id, calendarDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Deleta o calendário.")
    public ResponseEntity<String> deleteCalendar(@PathVariable Long id) {
        String response = calendarService.deleteCalendar(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
