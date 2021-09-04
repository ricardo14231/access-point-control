package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.LocationDTO;
import dio.innovation.accessPointAPI.exceptions.ElementIdInconsistencyException;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.LocationMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.LocationModel;
import dio.innovation.accessPointAPI.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LocationService {

    private final LocationMapper locationMapper = LocationMapper.INSTANCE;

    private final LocationRepository locationRepository;

    public String createLocation(LocationDTO locationDTO) {
        LocationModel locationToSave = locationMapper.toModel(locationDTO);
        Long id = locationRepository.save(locationToSave).getId();
        return MessageResponse.messageObjCreate(id, "Localidade");
    }

    public LocationDTO findLocationById(Long id) {
        return locationMapper.toDTO(verifyIfExists(id));
    }

    public List<LocationDTO> listLocation() {
        return locationRepository.findAll().stream()
                .map(locationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateLocation(Long id, LocationDTO locationDTO) {
        verifyIfExists(id);
        verifyInconsistencyId(id, locationDTO.getId());

        locationRepository.save( locationMapper.toModel(locationDTO));

        return MessageResponse.messageObjUpdate(id, "Localidade");
    }

    public String deleteLocation(Long id) {
        verifyIfExists(id);

        locationRepository.deleteById(id);
        return MessageResponse.messageObjDelete(id, "Localidade");
    }

    private LocationModel verifyIfExists(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "Localidade"));
    }

    private void verifyInconsistencyId(Long idParam, Long idObj) {
        if(!idParam.equals(idObj))
            throw new ElementIdInconsistencyException();
    }
}
