package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.CalendarDTO;
import dio.innovation.accessPointAPI.dto.MovementDTO;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.MovementMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.CalendarModel;
import dio.innovation.accessPointAPI.model.MovementModel;
import dio.innovation.accessPointAPI.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovementService {

    private MovementMapper movementMapper = MovementMapper.INSTANCE;

    @Autowired
    private MovementRepository movementRepository;

    public String createMovement(MovementDTO movementDTO) {
        MovementModel movementToSave = movementMapper.toModel(movementDTO);
        Long id = movementRepository.save(movementToSave).getId().getIdMovement();
        return MessageResponse.messageObjCreate(id, "Movimentação");
    }

    public MovementDTO findMovementById(Long id) {
        return movementMapper.toDTO(verifyIfExists(id));
    }

    public List<MovementDTO> listMovement() {
        return movementRepository.findAll().stream()
                .map(movementMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateMovement(Long id, MovementDTO movementDTO) {
        verifyIfExists(id);
        movementRepository.save( movementMapper.toModel(movementDTO));

        return MessageResponse.messageObjUpdate(id, "Movimentação");
    }

    public String deleteMovement(Long id) {
        verifyIfExists(id);

        movementRepository.deleteById(id);
        return MessageResponse.messageObjDelete(id, "Movimentação");
    }

    private MovementModel verifyIfExists(Long id) {
        return movementRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "Movimentação"));
    }

}
