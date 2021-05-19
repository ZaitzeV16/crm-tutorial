package com.vaadin.tutorial.crm.backend.library.base.blackMagic.create;

@FunctionalInterface
public interface CreateProcess<MODEL, DTO> {

    MODEL execute(DTO dto);

}