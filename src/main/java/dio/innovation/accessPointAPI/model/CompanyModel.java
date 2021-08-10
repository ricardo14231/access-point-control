package dio.innovation.accessPointAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String corporateName;

    @Column(nullable = false, unique = true, length = 18)
    private String cnpj;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 50)
    private String district;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 50)
    private String state;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private String description;

    @Column
    private LocalDateTime createAt;
}
