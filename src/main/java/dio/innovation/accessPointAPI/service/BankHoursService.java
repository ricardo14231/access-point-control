package dio.innovation.accessPointAPI.service;

import dio.innovation.accessPointAPI.dto.BankHoursDTO;
import dio.innovation.accessPointAPI.exceptions.ElementNotFoundException;
import dio.innovation.accessPointAPI.mapper.BankHoursMapper;
import dio.innovation.accessPointAPI.messageResponse.MessageResponse;
import dio.innovation.accessPointAPI.model.BankHoursModel;
import dio.innovation.accessPointAPI.repository.BankHoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankHoursService {

    private final BankHoursMapper bankHoursMapper = BankHoursMapper.INSTANCE;

    private final BankHoursRepository bankHoursRepository;

    public String createBankHours(BankHoursDTO bankHoursDTO) {
        BankHoursModel bankHorsToSave = bankHoursMapper.toModel(bankHoursDTO);
        Long id = bankHoursRepository.save(bankHorsToSave).getId().getIdBankHours();
        return MessageResponse.messageObjCreate(id, "Banco de horas");
    }

    public BankHoursDTO findBankHoursById(BankHoursDTO.IdBankHoursDTO id) {
        return bankHoursMapper.toDTO(verifyIfExists(id));
    }

    public List<BankHoursDTO> listBankHours() {
        return bankHoursRepository.findAll().stream()
                .map(bankHoursMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String updateBankHours(BankHoursDTO bankHoursDTO) {
        verifyIfExists(bankHoursDTO.getId());

        bankHoursRepository.save( bankHoursMapper.toModel(bankHoursDTO));

        return MessageResponse.messageObjUpdate(bankHoursDTO.getId().getIdBankHours(), "Banco de horas");
    }

    public String deleteBankHours(BankHoursDTO.IdBankHoursDTO id) {
        BankHoursModel bankHours = verifyIfExists(id);

        bankHoursRepository.delete(bankHours);
        return MessageResponse.messageObjDelete(id.getIdBankHours(), "Banco de horas");
    }

    private BankHoursModel verifyIfExists(BankHoursDTO.IdBankHoursDTO idBank) {
        BankHoursModel.IdBankHoursModel id = bankHoursMapper.toIdModel(idBank);

        return bankHoursRepository.findById(id)
                .orElseThrow(() -> {
                    String msg = String.format("Banco de horas idBank: %o, idMovement: %o idUser: %o, não encontrado.",
                            id.getIdBankHours(),
                            id.getIdMovement(),
                            id.getIdUser());
                    return new ElementNotFoundException(msg);
                });
        }

}
