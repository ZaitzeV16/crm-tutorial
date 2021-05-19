package com.vaadin.tutorial.crm.backend.library.generator.slug;

public interface SlugableService {
    default String createSlug(String defaultSlug) {
        return defaultSlug;
    }
}
