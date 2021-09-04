package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.BankHoursDTO;
import dio.innovation.accessPointAPI.model.BankHoursModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankHoursMapper {

    BankHoursMapper INSTANCE = Mappers.getMapper(BankHoursMapper.class);

    BankHoursModel toModel(BankHoursDTO bankHoursDTO);
    BankHoursModel.IdBankHoursModel toIdModel(BankHoursDTO.IdBankHoursDTO idBankHoursModel);

    BankHoursDTO toDTO(BankHoursModel bankHoursModel);
    BankHoursDTO.IdBankHoursDTO toIdDTO(BankHoursModel.IdBankHoursModel idBankHoursModel);
}
