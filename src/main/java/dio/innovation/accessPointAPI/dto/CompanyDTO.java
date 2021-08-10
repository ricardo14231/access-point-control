package dio.innovation.accessPointAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    private Long id;

    @NotEmpty
    private String corporateName;

    @NotEmpty
    private String cnpj;

    @NotEmpty
    private String address;

    @NotEmpty
    @Size(max = 50)
    private String district;

    @NotEmpty
    @Size(max = 50)
    private String city;

    @NotEmpty
    @Size(max = 50)
    private String state;

    @NotEmpty
    private String phoneNumber;

    private String description;

    private LocalDateTime createAt;
}
