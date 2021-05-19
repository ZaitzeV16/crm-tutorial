package com.vaadin.tutorial.crm.backend.library.base.blackMagic.create;

@FunctionalInterface
public interface CreateProcessToDTO<DTO> {

    <RESULT_DTO> RESULT_DTO executeToDto(DTO dto, Class<RESULT_DTO> resultDto);

}

