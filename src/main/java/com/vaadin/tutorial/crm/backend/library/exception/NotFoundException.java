package com.vaadin.tutorial.crm.backend.library.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends RuntimeException {

    private final ErrorType type;
    private final String errorMessage;
    private final HttpStatus httpStatus;

    public NotFoundException(String errorMessage) {
        super(errorMessage);
        this.type = ErrorType.NOT_FOUND_ERROR;
        this.errorMessage = errorMessage;
        this.httpStatus = HttpStatus.NOT_FOUND;
    }

    public NotFoundException(String errorMessage, ErrorType type) {
        super(errorMessage);
        this.type = type;
        this.errorMessage = errorMessage;
        this.httpStatus = HttpStatus.NOT_FOUND;
    }

}