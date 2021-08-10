package dio.innovation.accessPointAPI.exceptions;

import java.util.NoSuchElementException;

public class ElementNotFoundException extends NoSuchElementException {

    public ElementNotFoundException(Long id, String typeObject) {
        super(String.format("%s com ID: %o não encontrado(a)!", typeObject, id));
    }
}
