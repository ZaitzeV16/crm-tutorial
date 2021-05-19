package com.vaadin.tutorial.crm.backend.library.base.dto.history;

import hu.hellp.mdss.annotation.MdsDTO;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryChildOf;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MdsDTO(targetModel = HistoryChildOf.class)
public class HistoryChildDTO extends HistoryDTO {

}
