package com.vaadin.tutorial.crm.backend.library.base.blackMagic.filterer;

import org.springframework.stereotype.Service;

@Service
public class FiltererService<MODEL, DTO> {

    public SingletonOperation<MODEL, DTO> filter(String dtoClassName) {
        return new FiltererOperation<>(dtoClassName);
    }

}
