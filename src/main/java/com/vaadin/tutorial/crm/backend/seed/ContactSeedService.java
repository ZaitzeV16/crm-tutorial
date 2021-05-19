package com.vaadin.tutorial.crm.backend.seed;

import com.vaadin.tutorial.crm.backend.entity._leftover.company.CompanyService;
import com.vaadin.tutorial.crm.backend.entity._leftover.company.model.Company;
import com.vaadin.tutorial.crm.backend.entity._leftover.contact.ContactService;
import com.vaadin.tutorial.crm.backend.entity._leftover.contact.model.Contact;
import com.vaadin.tutorial.crm.backend.entity._leftover.contact.status.ContactStatus;
import com.vaadin.tutorial.crm.backend.library.base.seed.BaseSeedService;
import com.vaadin.tutorial.crm.backend.library.base.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

@SeedService(dependsOn = CompanySeedService.class)
public class ContactSeedService extends BaseSeedService<Contact, ContactService> {

    private final CompanyService companyService;
    private final Random r = new Random(0);


    @Autowired
    public ContactSeedService(ContactService ContactService, CompanyService companyService) {
        super(ContactService);
        this.companyService = companyService;
    }

    @Override
    public List<Contact> generateSeedData() {
        List<String> names = List.of("Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
                "Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
                "Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
                "Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
                "Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
                "Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
                "Jaydan Jackson", "Bernard Nilsen");

        List<Company> companies = this.companyService.findAll();

        return names
                .stream()
                .map(name -> createContact(companies, name))
                .collect(toList());
    }

    private Contact createContact(List<Company> companies, String name) {
        String[] split = name.split(" ");
        Contact contact = new Contact();

        contact.setFirstName(split[0]);
        contact.setLastName(split[1]);
        contact.setCompany(companies.get(this.r.nextInt(companies.size())));
        contact.setStatus(ContactStatus.values()[r.nextInt(ContactStatus.values().length)]);
        String email = (contact.getFirstName() + "." + contact.getLastName() + "@" + contact.getCompany().getName().replaceAll("[\\s-]", "") + ".com")
                .toLowerCase();
        contact.setEmail(email);

        return contact;
    }

}
