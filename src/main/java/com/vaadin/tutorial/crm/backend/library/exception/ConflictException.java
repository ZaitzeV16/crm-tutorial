package com.vaadin.tutorial.crm.backend.library.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ConflictException extends RuntimeException {

    private final String errorMessage;
    private final HttpStatus httpStatus;

    public ConflictException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.httpStatus = HttpStatus.CONFLICT;
    }

}