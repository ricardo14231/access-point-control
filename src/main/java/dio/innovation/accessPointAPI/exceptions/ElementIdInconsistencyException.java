package dio.innovation.accessPointAPI.exceptions;

import java.util.IllegalFormatConversionException;

public class ElementIdInconsistencyException extends IllegalFormatConversionException {

    public ElementIdInconsistencyException() {
        super('c', Void.class);
    }
}
