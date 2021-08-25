package dio.innovation.accessPointAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankHoursModel {

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdBankHoursModel implements Serializable {
        private Long idBankHours;
        private Long idMovement;
        private Long idUser;
    }

    @EmbeddedId
    private IdBankHoursModel id;

    private LocalDate dateWorked;

    private BigDecimal numberHoursWorked;

    private BigDecimal balanceHoursWorked;

    private LocalDateTime createAt;

}
