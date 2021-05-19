package com.vaadin.tutorial.crm.backend.library.base.blackMagic.create;

import javax.persistence.Transient;

public interface iCreate<MODEL, DTO> {

    @SuppressWarnings("unchecked")
    @Transient
    default MODEL save(CreateProcess<MODEL, DTO> createProcess) {
        DTO that = (DTO) this;      // let that = this - yeeeeeeeeeeeaaaah
        return createProcess.execute(that);
    }

    @SuppressWarnings("unchecked")
    @Transient
    default <RESULT_DTO> RESULT_DTO save(CreateProcessToDTO<DTO> createProcess, Class<RESULT_DTO> resultDtoClass) {
        DTO that = (DTO) this;
        return createProcess.executeToDto(that, resultDtoClass);
    }

}