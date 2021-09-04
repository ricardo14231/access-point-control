package dio.innovation.accessPointAPI.dto;

import dio.innovation.accessPointAPI.model.AccessLevelModel;
import dio.innovation.accessPointAPI.model.CompanyModel;
import dio.innovation.accessPointAPI.model.UserCategoryModel;
import dio.innovation.accessPointAPI.model.WorkDayModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotNull
    @Valid
    private UserCategoryModel userCategory;

    @NotEmpty
    @Valid
    private String name;

    @NotNull
    @Valid
    private CompanyModel company;

    @NotNull
    @Valid
    private AccessLevelModel accessLevel;

    @NotNull
    @Valid
    private WorkDayModel workDay;

    @NotNull
    @Valid
    private BigDecimal tolerance;

    @NotNull
    @Valid
    private LocalDateTime startTimeWorking;

    @NotNull
    @Valid
    private LocalDateTime endTimeWorking;

    private LocalDateTime createAt;
}
