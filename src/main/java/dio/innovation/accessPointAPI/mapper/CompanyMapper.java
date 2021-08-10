package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.CompanyDTO;
import dio.innovation.accessPointAPI.model.CompanyModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyModel toModel(CompanyDTO companyDTO);

    CompanyDTO toDTO(CompanyModel companyModel);
}
