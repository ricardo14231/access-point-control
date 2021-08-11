package dio.innovation.accessPointAPI.dto;

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
public class WorkDayDTO {

    private Long id;

    @NotEmpty
    private String description;

    private LocalDateTime createAt;
}
