package dio.innovation.accessPointAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovementModel {

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class IdMovementModel implements Serializable {
        private Long idMovement;
        private Long idUser;
    }

    @EmbeddedId
    private IdMovementModel id;

    private LocalDateTime dateEntry;

    private LocalDateTime dateExit;

    private BigDecimal residencePeriod;

    @ManyToOne
    private OccurrenceModel occurrence;

    @ManyToOne
    private CalendarModel calendar;

    private LocalDateTime createAt;
}
