package com.vaadin.tutorial.crm.backend.library.exception;

public enum ErrorType {
    PRODUCT_ERROR("ProductError", 400),
    NOT_FOUND_ERROR("NotFoundError", 401),
    UNHANDLED_NOT_FOUND_ERROR("UnhandledNotFoundError", 4010),
    BAD_REQUEST_ERROR("BadRequestError", 402),
    CONFLICT_ERROR("ConflictError", 403),
    INTERNAL_SERVER_ERROR("InternalServerError", 404),
    CONFLICT_EVENT_ERROR("ConflictEventError", 409),
    CONSTRAINT_ERROR("ValidationError", 420),
    FILE_ERROR("FileError", 440),
    PASSKIT_ERROR("PasskitError", 460),
    DTO_ERROR("DTOError", 44),
    SYSTEM_ERROR("SystemError", 666);

    public final String label;
    public final int code;

    ErrorType(String label, int code) {
        this.label = label;
        this.code = code;
    }

}
