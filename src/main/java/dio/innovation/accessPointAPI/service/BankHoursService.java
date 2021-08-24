package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.BankHoursDTO;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.BankHoursMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.BankHoursModel;
import dio.innovation.accessPointAPI.repository.BankHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankHoursService {

    private BankHoursMapper bankHoursMapper = BankHoursMapper.INSTANCE;

    @Autowired
    private BankHoursRepository bankHoursRepository;

    public String createBankHours(BankHoursDTO bankHoursDTO) {
        BankHoursModel bankHorsToSave = bankHoursMapper.toModel(bankHoursDTO);
        Long id = bankHoursRepository.save(bankHorsToSave).getId().getIdBankHours();
        return MessageResponse.messageObjCreate(id, "Banco de horas");
    }

    public BankHoursDTO findBankHoursById(Long id) {
        return bankHoursMapper.toDTO(verifyIfExists(id));
    }

    public List<BankHoursDTO> listBankHours() {
        return bankHoursRepository.findAll().stream()
                .map(bankHoursMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateBankHours(Long id, BankHoursDTO bankHoursDTO) {
        verifyIfExists(id);
        bankHoursRepository.save( bankHoursMapper.toModel(bankHoursDTO));

        return MessageResponse.messageObjUpdate(id, "Banco de horas");
    }

    public String deleteBankHours(Long id) {
        verifyIfExists(id);

        bankHoursRepository.deleteById(id);
        return MessageResponse.messageObjDelete(id, "Banco de horas");
    }

    private BankHoursModel verifyIfExists(Long id) {
        return bankHoursRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, "Banco de horas"));
    }
}
