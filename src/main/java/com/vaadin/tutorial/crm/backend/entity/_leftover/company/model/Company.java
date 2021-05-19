package com.vaadin.tutorial.crm.backend.entity._leftover.company.model;

import com.vaadin.tutorial.crm.backend.entity._leftover.contact.model.Contact;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "company", fetch = EAGER)
    private List<Contact> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public int getEmployeeSize() {
        return this.employees.size();
    }

}