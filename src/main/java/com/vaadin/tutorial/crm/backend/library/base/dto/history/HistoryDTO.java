package com.vaadin.tutorial.crm.backend.library.base.dto.history;

import hu.hellp.mdss.annotation.MdsDTO;
import com.vaadin.tutorial.crm.backend.library.base.dto.base.BaseDTO;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryEntity;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.type.HistoryEntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import service.entity.pkgUser.user.dto.SimpleUserDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MdsDTO(targetModel = HistoryEntity.class)
public class HistoryDTO extends BaseDTO {

//    private SimpleUserDTO modifier;
    private HistoryEntityType status;

}
