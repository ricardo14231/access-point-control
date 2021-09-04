package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.CompanyDTO;
import dio.innovation.accessPointAPI.exceptions.ElementIdInconsistencyException;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.CompanyMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.CompanyModel;
import dio.innovation.accessPointAPI.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyMapper companyMapper = CompanyMapper.INSTANCE;

    @Autowired
    private CompanyRepository companyRepository;

    public String createCompany(CompanyDTO companyDTO) {
        CompanyModel companyToSave = companyMapper.toModel(companyDTO);
        Long id = companyRepository.save(companyToSave).getId();

        return MessageResponse.messageObjCreate(id, "Empresa");
    }

    public CompanyDTO findCompanyById(Long id) {
        CompanyModel company = verifyIfExists(id);
        return companyMapper.toDTO(company);
    }

    public List<CompanyDTO> listAllCompany() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateCompany(Long id, CompanyDTO companyDTO) {
        verifyIfExists(id);
        verifyInconsistencyId(id, companyDTO.getId());

        CompanyModel companyToUpdate = companyMapper.toModel(companyDTO);
        Long idCompanyToUpdate = companyRepository.save(companyToUpdate).getId();
        return MessageResponse.messageObjUpdate(idCompanyToUpdate, "Empresa");
    }

    public String deleteCompany(Long id) {
        verifyIfExists(id);

        companyRepository.deleteById(id);
        return MessageResponse.messageObjDelete(id, "Empresa");
    }

    private CompanyModel verifyIfExists(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "Empresa"));
    }

    private void verifyInconsistencyId(Long idParam, Long idObj) {
        if(idParam != idObj)
            throw new ElementIdInconsistencyException();
    }
}
