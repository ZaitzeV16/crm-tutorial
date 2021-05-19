package com.vaadin.tutorial.crm.backend.library.exception;

//import com.vaadin.tutorial.crm.backend.library.Translator;
import com.vaadin.tutorial.crm.backend.library.payload.ConflictEventDataPayload;
import com.vaadin.tutorial.crm.backend.library.payload.DataPayload;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Log4j
public class ExceptionController {

    private final DataPayload<Map<String, String>> errorPayload = new DataPayload<>();

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<DataPayload> exception(NotFoundException exception) {
        log.error("NotFoundException: " + exception.getMessage());

        errorPayload.setId(exception.getType().code);
        errorPayload.setType(exception.getType().label);

        Map<String, String> errors = new HashMap<>();
//        errors.put("message", Translator.toLocale(exception.getErrorMessage()));
        errors.put("code", exception.getHttpStatus().toString());
        errorPayload.setAttribute(errors);

        return new ResponseEntity<>(errorPayload, exception.getHttpStatus());
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<DataPayload> exception(BadRequestException exception) {
        log.error("BadRequestException: " + exception.getMessage());

        errorPayload.setId(ErrorType.BAD_REQUEST_ERROR.code);
        errorPayload.setType(ErrorType.BAD_REQUEST_ERROR.label);

        Map<String, String> errors = new HashMap<>();
//        errors.put("message", Translator.toLocale(exception.getErrorMessage()));
        errors.put("code", exception.getHttpStatus().toString());
        errorPayload.setAttribute(errors);

        return new ResponseEntity<>(errorPayload, exception.getHttpStatus());
    }

    @ExceptionHandler(value = ConflictException.class)
    public ResponseEntity<DataPayload> exception(ConflictException exception) {
        log.error("ConflictException: " + exception.getMessage());

        errorPayload.setId(ErrorType.CONFLICT_ERROR.code);
        errorPayload.setType(ErrorType.CONFLICT_ERROR.label);

        Map<String, String> errors = new HashMap<>();
//        errors.put("message", Translator.toLocale(exception.getErrorMessage()));
        errors.put("code", exception.getHttpStatus().toString());
        errorPayload.setAttribute(errors);

        return new ResponseEntity<>(errorPayload, exception.getHttpStatus());
    }

    @ExceptionHandler(value = InternalServerErrorException.class)
    public ResponseEntity<DataPayload> exception(InternalServerErrorException exception) {
        log.error("InternalServerErrorException: " + exception.getMessage());

        errorPayload.setId(ErrorType.INTERNAL_SERVER_ERROR.code);
        errorPayload.setType(ErrorType.INTERNAL_SERVER_ERROR.label);

        Map<String, String> errors = new HashMap<>();
//        errors.put("message", Translator.toLocale(exception.getErrorMessage()));
        errors.put("code", exception.getHttpStatus().toString());
        errorPayload.setAttribute(errors);

        return new ResponseEntity<>(errorPayload, exception.getHttpStatus());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<DataPayload> exception(ConstraintViolationException exception) {
        log.error("ConstraintViolationException: " + exception.getMessage());

        errorPayload.setId(ErrorType.CONSTRAINT_ERROR.code);
        errorPayload.setType(ErrorType.CONSTRAINT_ERROR.label);

        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
//            errors.put(violation.getPropertyPath().toString(), Translator.toLocale(violation.getMessageTemplate()));
        }
        errorPayload.setAttribute(errors);

        return ResponseEntity.badRequest().body(errorPayload);
    }

    @ExceptionHandler(value = ConflictEventException.class)
    public ResponseEntity<DataPayload> exception(ConflictEventException exception) {
        log.error("ConflictEventException: " + exception.getMessage());

        ConflictEventDataPayload<Map<String, String>> conflictEventDataPayload = new ConflictEventDataPayload<>();

        conflictEventDataPayload.setId(ErrorType.CONFLICT_EVENT_ERROR.code);
        conflictEventDataPayload.setType(ErrorType.CONFLICT_EVENT_ERROR.label);

        Map<String, String> errors = new HashMap<>();
//        errors.put("message", Translator.toLocale(exception.getErrorMessage()));
        errors.put("code", exception.getHttpStatus().toString());
        conflictEventDataPayload.setAttribute(errors);

        conflictEventDataPayload.setEventData(exception.getEventData());

        return new ResponseEntity<>(conflictEventDataPayload, exception.getHttpStatus());
    }

    @ExceptionHandler(value = {MyFileNotFoundException.class, FileStorageException.class})
    public ResponseEntity<DataPayload> exception(Throwable exception) {
        log.error("FileStorage or MyFile exception: " + exception.getMessage());

        errorPayload.setId(ErrorType.FILE_ERROR.code);
        errorPayload.setType(ErrorType.FILE_ERROR.label);

        Map<String, String> errors = new HashMap<>();

//        errors.put("message", Translator.toLocale(exception.getMessage()));
        errors.put("code", HttpStatus.CONFLICT.toString());
        errorPayload.setAttribute(errors);

        return ResponseEntity.badRequest().body(errorPayload);
    }

    /**
     * Elfogja az összes keletkezett Exception típust és logbejegyzést készít.
     *
     * @param exception A keletkezett kivétel
     * @return 500 internal server error és a kivétel ami dobódott
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<DataPayload> exception(Exception exception) {
        Throwable rootCause = exception;
        while (rootCause.getCause() != null) {
            rootCause = rootCause.getCause();
        }
        log.error(rootCause.getClass().getName() + ": " + rootCause.getMessage());
        exception.printStackTrace();
        errorPayload.setId(ErrorType.SYSTEM_ERROR.code);
        errorPayload.setType(ErrorType.SYSTEM_ERROR.label);
        Map<String, String> errors = new HashMap<>();
        errors.put("message", rootCause.getMessage());
        errors.put("code", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errorPayload.setAttribute(errors);
        return new ResponseEntity<>(errorPayload, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
