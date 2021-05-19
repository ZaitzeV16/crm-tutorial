package com.vaadin.tutorial.crm.backend.library.logging;

public interface LoggableService {
    void createEventLog(Long id, String message);
}
