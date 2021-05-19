package com.vaadin.tutorial.crm.backend.library.base.repository;

import com.vaadin.tutorial.crm.backend.library.base.entity.history.HistoryChildOf;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface HistoryChildJpaRepo<CHILD extends HistoryChildOf<?>, ID>
        extends BaseJpaRepo<CHILD, ID> {

}
