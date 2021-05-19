package com.vaadin.tutorial.crm.backend.library.exception;

import lombok.Getter;

@Getter
public class PasskitException extends RuntimeException {

    private final String errorMessage;

    public PasskitException(String m) {
        this.errorMessage = m;
    }

}
