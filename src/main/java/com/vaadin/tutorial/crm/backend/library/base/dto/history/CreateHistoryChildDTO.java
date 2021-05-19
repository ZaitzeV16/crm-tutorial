package com.vaadin.tutorial.crm.backend.library.base.dto.history;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.create.iCreate;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryChildOf;


public class CreateHistoryChildDTO<MODEL extends HistoryChildOf<?>, DTO extends CreateHistoryChildDTO<MODEL, DTO>> extends HistoryChildDTO implements iCreate<MODEL, DTO> {

}
