package com.vaadin.tutorial.crm.backend.library.base.dto.history;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.update.iUpdate;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryParentOf;


public class UpdateHistoryParentDTO<MODEL extends HistoryParentOf<?>, DTO extends UpdateHistoryParentDTO<MODEL, DTO>> extends HistoryParentDTO implements iUpdate<MODEL, DTO> {

}
