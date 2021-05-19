package com.vaadin.tutorial.crm.backend.library.base.blackMagic.read;

import java.util.List;

@FunctionalInterface
public interface ReadProcess<DTO, FILTER> {

    List<DTO> readProcess(FILTER filter);

}
