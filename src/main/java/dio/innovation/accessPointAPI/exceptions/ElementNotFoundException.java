package dio.innovation.accessPointAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementNotFoundException extends NoSuchElementException {

    public ElementNotFoundException(Long id, String typeObject) {
        super(String.format("%s com ID: %o não encontrado(a)!", typeObject, id));
    }
}
