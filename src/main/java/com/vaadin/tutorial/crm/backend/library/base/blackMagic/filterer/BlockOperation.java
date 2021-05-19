package com.vaadin.tutorial.crm.backend.library.base.blackMagic.filterer;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.ReadProcess;

import java.util.List;

public interface BlockOperation<MODEL, DTO> {
    SingletonOperation<MODEL, DTO> and();

    SingletonOperation<MODEL, DTO> or();

    SingletonOperation<MODEL, DTO> orBlock();

    List<DTO> find(ReadProcess readProcess);
}
