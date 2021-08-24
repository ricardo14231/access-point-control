package dio.innovation.accessPointAPI.dto;

import dio.innovation.accessPointAPI.model.DateTypeModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalendarDTO {

    private Long id;

    @NotEmpty
    private DateTypeModel dateType;

    private String description;

    private LocalDateTime specialDate;

}
