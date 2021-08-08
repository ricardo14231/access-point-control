package dio.innovation.accessPointAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserCategoryModel userCategory;

    private String name;

    @ManyToOne
    private CompanyModel company;

    @ManyToOne
    private AccessLevelModel accessLevel;

    @ManyToOne
    private WorkDayModel workDay;

    private BigDecimal tolerance;

    private LocalDateTime startTimeWorking;

    private LocalDateTime endTimeWorking;

    private LocalDateTime createAt;
}
