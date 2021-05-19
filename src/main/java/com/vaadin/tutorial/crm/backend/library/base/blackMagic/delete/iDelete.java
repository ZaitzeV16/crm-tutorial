package com.vaadin.tutorial.crm.backend.library.base.blackMagic.delete;

import javax.persistence.Transient;

public interface iDelete<DTO> {

    @Transient
    default void delete(DeleteProcess<DTO> deleteProcess) {
        DTO that = (DTO) this;
        deleteProcess.deleteProcess(that);
    }

}