package com.vaadin.tutorial.crm.backend.library.base.dto.base;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.create.iCreate;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;


public class CreateBaseDTO<MODEL extends BaseEntity, DTO extends CreateBaseDTO<MODEL, DTO>> extends BaseDTO implements iCreate<MODEL, DTO> {

}
