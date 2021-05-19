package com.vaadin.tutorial.crm.backend.library.base.entity.history.type;

public enum HistoryEntityType {
    DRAFT("draft"),
    PUBLISHED("published"),
    UNPUBLISHED("unpublished"),
    DEPRECATED("deprecated");

    public final String label;

    HistoryEntityType(String label) {
        this.label = label;
    }

}
