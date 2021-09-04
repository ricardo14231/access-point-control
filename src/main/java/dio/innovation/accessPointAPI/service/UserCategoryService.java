package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.UserCategoryDTO;
import dio.innovation.accessPointAPI.exceptions.ElementIdInconsistencyException;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.UserCategoryMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.UserCategoryModel;
import dio.innovation.accessPointAPI.repository.UserCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCategoryService {

    private final UserCategoryMapper userCategoryMapper = UserCategoryMapper.INSTANCE;

    @Autowired
    private UserCategoryRepository userCategoryRepository;

    public String createUserCategory(UserCategoryDTO userCategoryDTO) {
        UserCategoryModel userCategoryToSaved = userCategoryMapper.toModel(userCategoryDTO);
        Long id = userCategoryRepository.save(userCategoryToSaved).getId();
        return MessageResponse.messageObjCreate(id, "Categoria");
    }

    public UserCategoryDTO findUserCategoryById(Long id) {
        UserCategoryModel userCategory = verifyIfExists(id);

        return userCategoryMapper.toDTO(userCategory);
    }

    public List<UserCategoryDTO> listUserCategory() {
        return userCategoryRepository.findAll().stream()
                .map(userCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateUserCategory(Long id, UserCategoryDTO userCategoryDTO) {
        verifyIfExists(id);
        verifyInconsistencyId(id, userCategoryDTO.getId());

        UserCategoryModel userCategoryToUpdate = userCategoryMapper.toModel(userCategoryDTO);
        Long idUserCategoryToUpdate = userCategoryRepository.save(userCategoryToUpdate).getId();
        return MessageResponse.messageObjUpdate(idUserCategoryToUpdate, "Categoria");
    }

    public String deleteUserCategory(Long id) {
        verifyIfExists(id);

        userCategoryRepository.deleteById(id);
        return MessageResponse.messageObjDelete(id, "Categoria");
    }

    private UserCategoryModel verifyIfExists(Long id) {
        return userCategoryRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "Categoria"));
    }

    private void verifyInconsistencyId(Long idParam, Long idObj) {
        if(idParam != idObj)
            throw new ElementIdInconsistencyException();
    }
}
