package com.vaadin.tutorial.crm.backend.library.base.blackMagic.update;

@FunctionalInterface
public interface UpdateProcessToDTO<DTO> {

    <RESULT_DTO> RESULT_DTO executeToDto(DTO dto, Class<RESULT_DTO> resultDto);

}

