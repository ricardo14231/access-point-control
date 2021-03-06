package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.DateTypeDTO;
import dio.innovation.accessPointAPI.exceptions.ElementIdInconsistencyException;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.DateTypeMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.DateTypeModel;
import dio.innovation.accessPointAPI.repository.DateTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DateTypeService {

    private final DateTypeMapper dateTypeMapper = DateTypeMapper.INSTANCE;

    private final DateTypeRepository dateTypeRepository;

    public String createDateType(DateTypeDTO dateTypeDTO) {
        DateTypeModel dateTypeToSave = dateTypeMapper.toModel(dateTypeDTO);
        Long id = dateTypeRepository.save(dateTypeToSave).getId();
        return MessageResponse.messageObjCreate(id, "Tipo data");
    }

    public DateTypeDTO findDateTypeById(Long id) {
        return dateTypeMapper.toDTO( verifyIfExists(id) );
    }

    public List<DateTypeDTO> listDateType() {
        return dateTypeRepository.findAll().stream()
                .map(dateTypeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateDateType(Long id, DateTypeDTO dateTypeDTO) {
        verifyIfExists(id);
        verifyInconsistencyId(id, dateTypeDTO.getId());

        dateTypeRepository.save( dateTypeMapper.toModel(dateTypeDTO));

        return MessageResponse.messageObjUpdate(id, "Tipo data");
    }

    public String deleteDateType(Long id) {
        verifyIfExists(id);

        dateTypeRepository.deleteById(id);
        return MessageResponse.messageObjDelete(id, "Tipo data");
    }

    private DateTypeModel verifyIfExists(Long id) {
        return dateTypeRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "tipo data"));
    }

    private void verifyInconsistencyId(Long idParam, Long idObj) {
        if(!idParam.equals(idObj))
            throw new ElementIdInconsistencyException();
    }
}
