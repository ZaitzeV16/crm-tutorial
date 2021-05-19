package com.vaadin.tutorial.crm.backend.library.exception;

import lombok.Getter;

@Getter
public class KeycloakException extends RuntimeException {

    private final String errorMessage;
    private final int httpStatus;

    public KeycloakException(String errorMessage, int httpStatus) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

}
