package com.vaadin.tutorial.crm.backend.library.generator.slug;

@FunctionalInterface
public interface SlugCreator {
    String createExtendedSlugByDefault(String defaultSlug);
}
