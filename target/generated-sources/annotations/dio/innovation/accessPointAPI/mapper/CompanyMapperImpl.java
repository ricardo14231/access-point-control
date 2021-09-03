package dio.innovation.accessPointAPI.mapper;

import dio.innovation.accessPointAPI.dto.CompanyDTO;
import dio.innovation.accessPointAPI.model.CompanyModel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-27T19:10:03-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyModel toModel(CompanyDTO companyDTO) {
        if ( companyDTO == null ) {
            return null;
        }

        CompanyModel companyModel = new CompanyModel();

        companyModel.setId( companyDTO.getId() );
        companyModel.setCorporateName( companyDTO.getCorporateName() );
        companyModel.setCnpj( companyDTO.getCnpj() );
        companyModel.setAddress( companyDTO.getAddress() );
        companyModel.setDistrict( companyDTO.getDistrict() );
        companyModel.setCity( companyDTO.getCity() );
        companyModel.setState( companyDTO.getState() );
        companyModel.setPhoneNumber( companyDTO.getPhoneNumber() );
        companyModel.setDescription( companyDTO.getDescription() );
        companyModel.setCreateAt( companyDTO.getCreateAt() );

        return companyModel;
    }

    @Override
    public CompanyDTO toDTO(CompanyModel companyModel) {
        if ( companyModel == null ) {
            return null;
        }

        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setId( companyModel.getId() );
        companyDTO.setCorporateName( companyModel.getCorporateName() );
        companyDTO.setCnpj( companyModel.getCnpj() );
        companyDTO.setAddress( companyModel.getAddress() );
        companyDTO.setDistrict( companyModel.getDistrict() );
        companyDTO.setCity( companyModel.getCity() );
        companyDTO.setState( companyModel.getState() );
        companyDTO.setPhoneNumber( companyModel.getPhoneNumber() );
        companyDTO.setDescription( companyModel.getDescription() );
        companyDTO.setCreateAt( companyModel.getCreateAt() );

        return companyDTO;
    }
}
