package dio.innovation.accessPointAPI.dto;

import dio.innovation.accessPointAPI.model.BankHoursModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankHoursDTO {

    @NotNull
    private BankHoursModel.IdBankHoursModel id;

    @NotNull
    private LocalDate dateWorked;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal numberHoursWorked;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal balanceHoursWorked;
}
