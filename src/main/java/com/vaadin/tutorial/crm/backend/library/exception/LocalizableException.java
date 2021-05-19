package com.vaadin.tutorial.crm.backend.library.exception;

public class LocalizableException extends RuntimeException {
    private final String errorMessage;

    public LocalizableException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
