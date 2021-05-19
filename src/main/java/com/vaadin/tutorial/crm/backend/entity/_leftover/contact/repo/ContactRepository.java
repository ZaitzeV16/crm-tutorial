package com.vaadin.tutorial.crm.backend.entity._leftover.contact.repo;

import com.vaadin.tutorial.crm.backend.entity._leftover.contact.model.Contact;
import com.vaadin.tutorial.crm.backend.library.base.repository.BaseEntityJpaRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends BaseEntityJpaRepo<Contact, Long> {

    @Query("select c from Contact c " +
            "where lower(c.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<Contact> search(@Param("searchTerm") String searchTerm);

}
