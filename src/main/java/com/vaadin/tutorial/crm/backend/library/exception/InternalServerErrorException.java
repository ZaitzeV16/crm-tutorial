package com.vaadin.tutorial.crm.backend.library.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InternalServerErrorException extends RuntimeException {

    private final String errorMessage;
    private final HttpStatus httpStatus;

    public InternalServerErrorException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

}