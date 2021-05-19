package com.vaadin.tutorial.crm.backend.library.base.blackMagic.update;

import javax.persistence.Transient;

public interface iUpdate<MODEL, DTO> {

    @SuppressWarnings("unchecked")
    @Transient
    default MODEL update(UpdateProcess<MODEL, DTO> updateProcess) {
        DTO that = (DTO) this;
        return updateProcess.execute(that);
    }

    @SuppressWarnings("unchecked")
    @Transient
    default <RESULT_DTO> RESULT_DTO update(UpdateProcessToDTO<DTO> updateProcess, Class<RESULT_DTO> resultDtoClass) {
        DTO that = (DTO) this;
        return updateProcess.executeToDto(that, resultDtoClass);
    }

}