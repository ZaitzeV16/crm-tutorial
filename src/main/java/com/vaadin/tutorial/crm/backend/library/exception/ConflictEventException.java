package com.vaadin.tutorial.crm.backend.library.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class ConflictEventException extends RuntimeException {

    private final String errorMessage;
    private final HttpStatus httpStatus = HttpStatus.CONFLICT;
    private final Map<Object, Object> eventData;

    public ConflictEventException(String errorMessage, Map<Object, Object> eventData) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.eventData = eventData;
    }

}