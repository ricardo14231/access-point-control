package dio.innovation.accessPointAPI.dto;

import dio.innovation.accessPointAPI.model.BankHoursModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankHoursDTO {

    @NotEmpty
    private BankHoursModel.IdBanckHoursModel id;

    @NotEmpty
    private LocalDate dateWorked;

    @NotEmpty
    private BigDecimal numberHoursWorked;

    @NotEmpty
    private BigDecimal balanceHoursWorked;
}
