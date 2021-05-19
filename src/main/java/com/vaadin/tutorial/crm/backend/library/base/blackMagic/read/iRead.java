package com.vaadin.tutorial.crm.backend.library.base.blackMagic.read;

import its.a.me.calendario.app.library.base.blackMagic.read.filter.Filterer;

import javax.persistence.Transient;
import java.util.List;

public interface iRead<DTO, FILTER extends Filterer> {

    @Transient
    default List<DTO> findAllByFilter(ReadProcess<DTO, FILTER> readProcess) {
        FILTER that = (FILTER) this;
        return readProcess.readProcess(that);
    }

}
