package com.vaadin.tutorial.crm.backend.library.base.dto.base;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.update.iUpdate;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;


public class UpdateBaseDTO<MODEL extends BaseEntity, DTO extends UpdateBaseDTO<MODEL, DTO>> extends BaseDTO implements iUpdate<MODEL, DTO> {

}
