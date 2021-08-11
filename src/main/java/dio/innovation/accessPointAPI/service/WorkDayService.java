package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.WorkDayDTO;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.WorkDayMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.WorkDayModel;
import dio.innovation.accessPointAPI.repository.WorkDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkDayService {

    @Autowired
    private WorkDayRepository workDayRepository;

    private final WorkDayMapper workDayMapper = WorkDayMapper.INSTANCE;

    public String createWorkDay(WorkDayDTO workDayDTO) {
        WorkDayModel workDayToSave = workDayMapper.toModel(workDayDTO);
        Long id = workDayRepository.save(workDayToSave).getId();
        return MessageResponse.messageObjCreate(id, "Jornada de trabalho");//messageResponse
    }

    public WorkDayDTO findWorkDayById(Long id) {
        return workDayMapper.toDTO( verifyIfExists(id) );
    }

    public List<WorkDayDTO> listAllWorkDay() {
        return workDayRepository.findAll().stream()
                .map(workDayMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateWorkDay(Long id, WorkDayDTO workDayDTO) {
        verifyIfExists(id);
        WorkDayModel workDayToUpdate = workDayMapper.toModel(workDayDTO);
        workDayRepository.save(workDayToUpdate);

        return MessageResponse.messageObjUpdate(id, "Jornada de trabalho");
    }

    public String deleteWorkDay(Long id) {
        verifyIfExists(id);
        workDayRepository.deleteById(id);

        return MessageResponse.messageObjDelete(id, "Jornada de trabalho");
    }

    private WorkDayModel verifyIfExists(Long id) {
        return workDayRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "Jornada de trabalho"));
    }
}
