package com.vaadin.tutorial.crm.backend.library.exception;

import lombok.Getter;

@Getter
public class DtoTypeEnumConfigValidationException extends RuntimeException {

    private final String errorMessage;

    public DtoTypeEnumConfigValidationException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

}