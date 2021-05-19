package com.vaadin.tutorial.crm.backend.library.payload.keycloak;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeycloakError {

    private String error;
    private String errorMessage;

}
