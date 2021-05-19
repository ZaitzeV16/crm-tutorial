package com.vaadin.tutorial.crm.backend.entity.user.repo;

import com.vaadin.tutorial.crm.backend.entity.user.model.User;
import com.vaadin.tutorial.crm.backend.library.base.repository.BaseEntityJpaRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends BaseEntityJpaRepo<User, Long> {

}
