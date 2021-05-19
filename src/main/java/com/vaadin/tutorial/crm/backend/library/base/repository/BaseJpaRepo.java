package com.vaadin.tutorial.crm.backend.library.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJpaRepo<MODEL, ID>
        extends JpaRepository<MODEL, ID>, JpaSpecificationExecutor<MODEL> {

}
