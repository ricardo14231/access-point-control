package dio.innovation.accessPointAPI.controller;

import dio.innovation.accessPointAPI.dto.CalendarDTO;
import dio.innovation.accessPointAPI.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @PostMapping("/create")
    public ResponseEntity<String> createCalendar(@RequestBody @Valid CalendarDTO calendarDTO) {
        String response = calendarService.createCalendar(calendarDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalendarDTO> findCalendarById(@PathVariable Long id) {
        return new ResponseEntity<>(calendarService.findCalendarById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CalendarDTO>> listCalendar() {
        return new ResponseEntity<>(calendarService.listCalendar(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String>
    updateCalendar(@PathVariable Long id, @RequestBody @Valid CalendarDTO calendarDTO) {

        String response = calendarService.updateCalendar(id, calendarDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCalendar(@PathVariable Long id) {
        String response = calendarService.deleteCalendar(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
