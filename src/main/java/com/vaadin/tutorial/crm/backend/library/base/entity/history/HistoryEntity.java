package com.vaadin.tutorial.crm.backend.library.base.entity.history;

import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import com.vaadin.tutorial.crm.backend.library.base.entity.history.type.HistoryEntityType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import static com.vaadin.tutorial.crm.backend.library.base.entity.history.type.HistoryEntityType.DRAFT;

//import service.entity.pkgUser.user.model.User;

@MappedSuperclass
@Getter
@Setter
abstract public class HistoryEntity extends BaseEntity {

//    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH})
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @JsonIgnore
//    private User modifier;

    @Column
    private HistoryEntityType status = DRAFT;

}
