package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.OccurrenceDTO;
import dio.innovation.accessPointAPI.exceptions.ElementIdInconsistencyException;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.OccurrenceMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.OccurrenceModel;
import dio.innovation.accessPointAPI.repository.OccurrenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OccurrenceService {

    private final OccurrenceMapper occurrenceMapper = OccurrenceMapper.INSTANCE;

    private final OccurrenceRepository occurrenceRepository;

    public String createOccurrence(OccurrenceDTO occurrenceDTO) {
        OccurrenceModel occurrenceToSave = occurrenceMapper.toModel(occurrenceDTO);
        Long id = occurrenceRepository.save(occurrenceToSave).getId();

        return MessageResponse.messageObjCreate(id, "Ocorrência");
    }

    public OccurrenceDTO findOccurenceById(Long id) {
        return occurrenceMapper.toDTO( verifyIfExists(id) );
    }

    public List<OccurrenceDTO> listAllOccurrence() {
        return occurrenceRepository.findAll().stream()
                .map(occurrenceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateOccurrence(Long id, OccurrenceDTO occurrenceDTO) {
        verifyIfExists(id);
        verifyInconsistencyId(id, occurrenceDTO.getId());

        OccurrenceModel occurrenceToUpdate = occurrenceMapper.toModel(occurrenceDTO);
        occurrenceRepository.save(occurrenceToUpdate);

        return MessageResponse.messageObjUpdate(id, "Ocorrência");
    }

    public String deleteOccurrence(Long id) {
        verifyIfExists(id);
        occurrenceRepository.deleteById(id);

        return MessageResponse.messageObjDelete(id, "Ocorrência");
    }

    private OccurrenceModel verifyIfExists(Long id) {
        return occurrenceRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "Ocorrência"));
    }

    private void verifyInconsistencyId(Long idParam, Long idObj) {
        if(!idParam.equals(idObj))
            throw new ElementIdInconsistencyException();
    }
}
