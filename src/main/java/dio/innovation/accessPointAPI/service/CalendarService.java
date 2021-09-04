package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.CalendarDTO;
import dio.innovation.accessPointAPI.exceptions.ElementIdInconsistencyException;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.CalendarMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.CalendarModel;
import dio.innovation.accessPointAPI.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarService {

    private CalendarMapper calendarMapper = CalendarMapper.INSTANCE;

    @Autowired
    private CalendarRepository calendarRepository;

    public String createCalendar(CalendarDTO calendarDTO) {
        CalendarModel calendarToSave = calendarMapper.toModel(calendarDTO);
        Long id = calendarRepository.save(calendarToSave).getId();
        return MessageResponse.messageObjCreate(id, "Calendário");
    }

    public CalendarDTO findCalendarById(Long id) {
        return calendarMapper.toDTO(verifyIfExists(id));
    }

    public List<CalendarDTO> listCalendar() {
        return calendarRepository.findAll().stream()
                .map(calendarMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateCalendar(Long id, CalendarDTO calendarDTO) {
        verifyIfExists(id);
        verifyInconsistencyId(id, calendarDTO.getId());

        calendarRepository.save( calendarMapper.toModel(calendarDTO));

        return MessageResponse.messageObjUpdate(id, "Calendário");
    }

    public String deleteCalendar(Long id) {
        verifyIfExists(id);

        calendarRepository.deleteById(id);
        return MessageResponse.messageObjDelete(id, "Calendário");
    }

    private CalendarModel verifyIfExists(Long id) {
        return calendarRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "Calendário"));
    }

    private void verifyInconsistencyId(Long idParam, Long idObj) {
        if(idParam != idObj)
            throw new ElementIdInconsistencyException();
    }
}
