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
    @JoinColumn(nullable = false)
    private UserCategoryModel userCategory;

    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CompanyModel company;

    @ManyToOne
    @JoinColumn(nullable = false)
    private AccessLevelModel accessLevel;

    @ManyToOne
    @JoinColumn(nullable = false)
    private WorkDayModel workDay;

    @Column(nullable = false)
    private BigDecimal tolerance;

    @Column(nullable = false)
    private LocalDateTime startTimeWorking;

    @Column(nullable = false)
    private LocalDateTime endTimeWorking;

    private LocalDateTime createAt;
}
