package com.vaadin.tutorial.crm.backend.library.generator.email;

@FunctionalInterface
public interface DynamicStringGenerator<MODEL> {
    String generateDynamicString(MODEL entity);
}
