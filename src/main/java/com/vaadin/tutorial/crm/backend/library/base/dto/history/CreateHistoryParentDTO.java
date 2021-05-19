package com.vaadin.tutorial.crm.backend.library.base.dto.history;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.create.iCreate;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryParentOf;


public class CreateHistoryParentDTO<MODEL extends HistoryParentOf<?>, DTO extends CreateHistoryParentDTO<MODEL, DTO>> extends HistoryParentDTO implements iCreate<MODEL, DTO> {

}
