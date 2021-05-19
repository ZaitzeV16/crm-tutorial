package com.vaadin.tutorial.crm.backend.entity._leftover.contact;

import com.vaadin.tutorial.crm.backend.entity._leftover.company.CompanyService;
import com.vaadin.tutorial.crm.backend.entity._leftover.company.model.Company;
import com.vaadin.tutorial.crm.backend.entity._leftover.contact.model.Contact;
import com.vaadin.tutorial.crm.backend.entity._leftover.contact.repo.ContactRepository;
import com.vaadin.tutorial.crm.backend.entity._leftover.contact.status.ContactStatus;
import com.vaadin.tutorial.crm.backend.library.base.service.BaseEntityService;
import hu.hellp.mdss.service.processor.ModelDtoSerializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class ContactService extends BaseEntityService<Contact, Long, ContactRepository> {

    private static final Logger LOGGER = Logger.getLogger(ContactService.class.getName());
    private final CompanyService companyService;

    @Autowired
    protected ContactService(ContactRepository repo, ModelDtoSerializerService mds, CompanyService companyService) {
        super(repo, mds);
        this.companyService = companyService;
    }

    public List<Contact> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return this.repo.findAll();
        } else {
            return this.repo.search(filterText);
        }
    }

    @PostConstruct
    public void populateTestData() {
        if (this.companyService.count() == 0) {
            this.companyService.saveAll(
                    Stream.of("Path-Way Electronics", "E-Tech Management", "Path-E-Tech Management")
                            .map(Company::new)
                            .collect(toList()));
        }

        if (this.count() == 0) {
            Random r = new Random(0);
            List<Company> companies = this.companyService.findAll();
            this.repo.saveAll(
                    Stream.of("Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
                            "Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
                            "Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
                            "Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
                            "Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
                            "Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
                            "Jaydan Jackson", "Bernard Nilsen")
                            .map(name -> {
                                String[] split = name.split(" ");
                                Contact contact = new Contact();
                                contact.setFirstName(split[0]);
                                contact.setLastName(split[1]);
                                contact.setCompany(companies.get(r.nextInt(companies.size())));
                                contact.setStatus(ContactStatus.values()[r.nextInt(ContactStatus.values().length)]);
                                String email = (contact.getFirstName() + "." + contact.getLastName() + "@" + contact.getCompany().getName().replaceAll("[\\s-]", "") + ".com").toLowerCase();
                                contact.setEmail(email);
                                return contact;
                            }).collect(toList()));
        }
    }

}
