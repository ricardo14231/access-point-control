package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.MovementDTO;
import dio.innovation.accessPointAPI.exceptions.ElementIdInconsistencyException;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.MovementMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.MovementModel;
import dio.innovation.accessPointAPI.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovementService {

    private final MovementMapper movementMapper = MovementMapper.INSTANCE;

    private final MovementRepository movementRepository;

    public String createMovement(MovementDTO movementDTO) {
        MovementModel movementToSave = movementMapper.toModel(movementDTO);
        Long id = movementRepository.save(movementToSave).getId().getIdMovement();
        return MessageResponse.messageObjCreate(id, "Movimentação");
    }

    public MovementDTO findMovementById(MovementDTO.IdMovementDTO id) {
        return movementMapper.toDTO(verifyIfExists(id));
    }

    public List<MovementDTO> listMovement() {
        return movementRepository.findAll().stream()
                .map(movementMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateMovement(MovementDTO movementDTO) {
        verifyIfExists(movementDTO.getId());
        verifyInconsistencyId(movementDTO.getId().getIdMovement(), movementDTO.getId().getIdMovement());
        verifyInconsistencyId(movementDTO.getId().getIdUser(), movementDTO.getId().getIdUser());

        movementRepository.save( movementMapper.toModel(movementDTO));

        return MessageResponse.messageObjUpdate(movementDTO.getId().getIdMovement(), "Movimentação");
    }

    public String deleteMovement(MovementDTO.IdMovementDTO id) {
        MovementModel movementToDelete = verifyIfExists(id);

        movementRepository.delete(movementToDelete);
        return MessageResponse.messageObjDelete(id.getIdMovement(), "Movimentação");
    }

    private MovementModel verifyIfExists(MovementDTO.IdMovementDTO idDTO) {
        MovementModel.IdMovementModel id = movementMapper.toIdModel(idDTO);
        return movementRepository.findById(id)
                .orElseThrow(() -> {
                    String msg = String.format("Movimentação idMoviment: %o, idUser: %o, não encontrado.",
                            id.getIdMovement(), id.getIdUser());
                    return new ElementNotFoundException(msg);
                });
    }

    private void verifyInconsistencyId(Long idParam, Long idObj) {
        if(!idParam.equals(idObj))
            throw new ElementIdInconsistencyException();
    }
}
