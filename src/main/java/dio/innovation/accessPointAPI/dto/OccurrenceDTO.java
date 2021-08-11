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
@NoArgsConstructor
@AllArgsConstructor
public class OccurrenceDTO {

    private Long id;

    @NotEmpty
    @Size(max = 50)
    private String name;

    private String description;

    private LocalDateTime createAt;
}
