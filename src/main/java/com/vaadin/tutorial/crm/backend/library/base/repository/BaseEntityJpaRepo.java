package com.vaadin.tutorial.crm.backend.library.base.repository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseEntityJpaRepo<MODEL, ID> extends BaseJpaRepo<MODEL, ID> {

}
