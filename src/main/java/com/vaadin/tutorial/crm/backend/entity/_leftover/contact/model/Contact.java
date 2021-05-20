package com.vaadin.tutorial.crm.backend.entity._leftover.contact.model;

import com.vaadin.tutorial.crm.backend.entity._leftover.company.model.Company;
import com.vaadin.tutorial.crm.backend.entity._leftover.contact.status.ContactStatus;
import com.vaadin.tutorial.crm.backend.library.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact extends BaseEntity implements Cloneable {

    @NotNull
    @NotBlank
    private String firstName = "";

    @NotNull
    @NotBlank
    private String lastName = "";

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ContactStatus status;

    @Email
    @NotNull
    @NotBlank
    private String email = "";

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
