package com.vaadin.tutorial.crm.backend.library.base.repository;

import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryParentOf;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface HistoryParentJpaRepo<PARENT extends HistoryParentOf<?>, ID>
        extends BaseJpaRepo<PARENT, ID> {

}
