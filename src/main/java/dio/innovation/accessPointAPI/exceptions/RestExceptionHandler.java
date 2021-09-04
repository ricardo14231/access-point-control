package dio.innovation.accessPointAPI.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    protected ResponseEntity<ExceptionDetails> handleElementNotFound(ElementNotFoundException exception) {
        return new ResponseEntity<>(
                ExceptionDetails
                        .builder()
                        .title(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .details("Item não encontrado.")
                        .timestamp(LocalDateTime.now()  )
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ElementIdInconsistencyException.class)
    protected ResponseEntity<ExceptionDetails> handleElementIdInconsistencyException(ElementIdInconsistencyException exception) {
        return new ResponseEntity<>(
                ExceptionDetails
                        .builder()
                        .title(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .details("Inconsistência entre o ID do parâmetro e do JSON.")
                        .timestamp(LocalDateTime.now()  )
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(SQLException.class)
    protected ResponseEntity<ExceptionDetails> handleIntegrityConstraintViolationEntity(SQLException exception) {
        return new ResponseEntity<>(
                ExceptionDetails
                        .builder()
                        .title(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .details("Erro ao persistir os dados.")
                        .timestamp(LocalDateTime.now()  )
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(
                ValidationFieldsExceptionsDetails.builder()
                        .title("Bad Request Exception. Campo(s) Inválido(s).")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .timestamp(LocalDateTime.now())
                        .details("Verifique os campos.")
                        .fields(fields)
                        .fieldsMessage(fieldMessage)
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @Override
    protected ResponseEntity handleHttpMessageNotReadable
            (HttpMessageNotReadableException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .details("Erro no formato do JSON.")
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity(exceptionDetails, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal
            (Exception exception, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Bad Request Exception." + exception.getLocalizedMessage())
                .status(status.value())
                .timestamp(LocalDateTime.now())
                .details(exception.getCause().getMessage())
                .build();

        return new ResponseEntity(exceptionDetails, headers, status);
    }
}
