package dio.innovation.accessPointAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankHoursDTO {

    @NotNull
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdBankHoursDTO implements Serializable {
        private Long idBankHours;
        private Long idMovement;
        private Long idUser;
    }

    @NotNull
    private BankHoursDTO.IdBankHoursDTO id;

    @NotNull
    private LocalDate dateWorked;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal numberHoursWorked;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal balanceHoursWorked;
}
