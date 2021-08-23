package dio.innovation.accessPointAPI.exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationFieldsExceptionsDetails extends ExceptionDetails{
    private final String fields;
    private final String fieldsMessage;
}
