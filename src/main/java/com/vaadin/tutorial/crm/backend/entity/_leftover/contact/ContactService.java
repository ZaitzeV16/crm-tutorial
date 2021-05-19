package com.vaadin.tutorial.crm.backend.entity._leftover.contact;

import com.vaadin.tutorial.crm.backend.entity._leftover.contact.model.Contact;
import com.vaadin.tutorial.crm.backend.entity._leftover.contact.repo.ContactRepository;
import com.vaadin.tutorial.crm.backend.library.base.service.BaseEntityService;
import hu.hellp.mdss.service.processor.ModelDtoSerializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService extends BaseEntityService<Contact, Long, ContactRepository> {

    @Autowired
    protected ContactService(ContactRepository repo, ModelDtoSerializerService mds) {
        super(repo, mds);
    }

    public List<Contact> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return this.repo.findAll();
        } else {
            return this.repo.search(filterText);
        }
    }

}
