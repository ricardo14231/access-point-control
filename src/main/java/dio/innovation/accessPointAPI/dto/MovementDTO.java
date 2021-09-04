package dio.innovation.accessPointAPI.dto;

import dio.innovation.accessPointAPI.model.CalendarModel;
import dio.innovation.accessPointAPI.model.OccurrenceModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovementDTO {

    @NotNull
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdMovementDTO implements Serializable {
        private Long idMovement;
        private Long idUser;
    }

    @NotNull
    private MovementDTO.IdMovementDTO id;

    @NotNull
    private LocalDateTime dateEntry;

    @NotNull
    private LocalDateTime dateExit;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal residencePeriod;

    @NotNull
    private OccurrenceModel occurrence;

    @NotNull
    private CalendarModel calendar;
}
