package dio.innovation.accessPointAPI.dto;

import dio.innovation.accessPointAPI.model.CalendarModel;
import dio.innovation.accessPointAPI.model.MovementModel;
import dio.innovation.accessPointAPI.model.OccurrenceModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovementDTO {

    @NotEmpty
    private MovementModel.IdMovementModel id;

    @NotEmpty
    private LocalDateTime dateEntry;

    @NotEmpty
    private LocalDateTime dateExit;

    @NotEmpty
    private BigDecimal residencePeriod;

    @NotEmpty
    private OccurrenceModel occurrence;

    @NotEmpty
    private CalendarModel calendar;
}
