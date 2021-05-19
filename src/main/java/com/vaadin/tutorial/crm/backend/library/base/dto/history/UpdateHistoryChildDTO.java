package com.vaadin.tutorial.crm.backend.library.base.dto.history;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.update.iUpdate;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryChildOf;


public class UpdateHistoryChildDTO<MODEL extends HistoryChildOf<?>, DTO extends UpdateHistoryChildDTO<MODEL, DTO>> extends HistoryChildDTO implements iUpdate<MODEL, DTO> {

}
