package com.vaadin.tutorial.crm.backend.library.base.blackMagic.update;

@FunctionalInterface
public interface UpdateProcess<MODEL, DTO> {

    MODEL execute(DTO dto);

}