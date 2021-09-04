package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.AccessLevelDTO;
import dio.innovation.accessPointAPI.exceptions.ElementIdInconsistencyException;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.AccessLevelMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.AccessLevelModel;
import dio.innovation.accessPointAPI.repository.AccessLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccessLevelService {

    private final AccessLevelMapper accessLevelMapper = AccessLevelMapper.INSTANCE;

    private final AccessLevelRepository accessLevelRepository;

    public String createAccessLevel(AccessLevelDTO accessLevelDTO) {
        AccessLevelModel accessLevelToSave = accessLevelMapper.toModel(accessLevelDTO);
        Long id = accessLevelRepository.save(accessLevelToSave).getId();
        return MessageResponse.messageObjCreate(id, "Nível de acesso");
    }

    public AccessLevelDTO findAccessLevelById(Long id) {
        return accessLevelMapper.toDTO(verifyIfExists(id));
    }

    public List<AccessLevelDTO> listAccessLevel() {
        return accessLevelRepository.findAll().stream()
                .map(accessLevelMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateAccessLevel(Long id, AccessLevelDTO accessLevelDTO) {
        verifyIfExists(id);
        verifyInconsistencyId(id, accessLevelDTO.getId());

        accessLevelRepository.save( accessLevelMapper.toModel(accessLevelDTO));

        return MessageResponse.messageObjUpdate(id, "Nível de acesso");
    }

    public String deleteAccessLevel(Long id) {
        verifyIfExists(id);

        accessLevelRepository.deleteById(id);
        return MessageResponse.messageObjDelete(id, "Nível de acesso");
    }

    private AccessLevelModel verifyIfExists(Long id) {
        return accessLevelRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "Nível de acesso"));
    }

    private void verifyInconsistencyId(Long idParam, Long idObj) {
        if(!idParam.equals(idObj))
            throw new ElementIdInconsistencyException();
    }
}
