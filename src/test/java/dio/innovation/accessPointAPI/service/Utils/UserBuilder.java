package dio.innovation.accessPointAPI.service.Utils;

import dio.innovation.accessPointAPI.dto.UserDTO;
import dio.innovation.accessPointAPI.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UserBuilder {

    public static UserModel createUserBuilder() {
        return UserModel.builder()
                .id(1L)
                .userCategory(UserCategoryModel.builder().id(1L).description("Test user").build())
                .name("User 1")
                .company(setCompany())
                .accessLevel(AccessLevelModel.builder().id(1L).description("Test user").build())
                .workDay(WorkDayModel.builder().id(1L).description("Test user").build())
                .tolerance(BigDecimal.valueOf(5))
                .startTimeWorking(LocalDateTime.now())
                .endTimeWorking(LocalDateTime.now())
                .build();
    }

    private static CompanyModel setCompany() {
        return CompanyModel.builder()
                .id(1L)
                .corporateName("Company test")
                .cnpj("13211-121-121/0201")
                .address("Address Test")
                .district("District Test")
                .city("City test")
                .state("State test")
                .phoneNumber("(00)000000000")
                .description("Description test")
                .build();
    }
}
