package dio.innovation.accessPointAPI.exceptions;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {

    private String title;
    private int status;
    private String details;
    private LocalDateTime timestamp;
}
