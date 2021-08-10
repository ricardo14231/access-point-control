package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.CompanyDTO;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.CompanyMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.CompanyModel;
import dio.innovation.accessPointAPI.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private CompanyMapper companyMapper = CompanyMapper.INSTANCE;

    @Autowired
    private CompanyRepository companyRepository;

    MessageResponse messageResponse;

    public String createCompany(CompanyDTO companyDTO) {
        CompanyModel companyToSave = companyMapper.toModel(companyDTO);
        Long id = companyRepository.save(companyToSave).getId();

        return messageResponse.messageObjCreate(id, "Empresa");
    }

    public CompanyDTO findCompanyById(Long id) {
        CompanyModel company = verifyIfExists(id);
        return companyMapper.toDTO(company);
    }

    public List<CompanyDTO> listAllCompany() {
        return companyRepository.findAll().stream()
                .map(company -> companyMapper.toDTO(company))
                .collect(Collectors.toList());
    }

    public String updateCompany(Long id, CompanyDTO companyDTO) {
        verifyIfExists(id);

        CompanyModel companyToUpdate = companyMapper.toModel(companyDTO);
        Long idCompanyToUpdate = companyRepository.save(companyToUpdate).getId();
        return messageResponse.messageObjUpdate(idCompanyToUpdate, "Empresa");
    }

    public String deleteCompany(Long id) {
        verifyIfExists(id);

        companyRepository.deleteById(id);
        return messageResponse.messageObjDelete(id, "Empresa");
    }

    private CompanyModel verifyIfExists(Long id) {
        CompanyModel company = companyRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "Empresa"));
        return company;
    }
}
