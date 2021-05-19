package com.vaadin.tutorial.crm.backend.library.base.dto;

public interface DtoClassContainer {

    <DTO> Class<DTO> getDtoClass();

}
