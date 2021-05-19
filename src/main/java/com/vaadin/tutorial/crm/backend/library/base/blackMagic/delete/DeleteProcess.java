package com.vaadin.tutorial.crm.backend.library.base.blackMagic.delete;

@FunctionalInterface
public interface DeleteProcess<DTO> {

    void deleteProcess(DTO dto);

}