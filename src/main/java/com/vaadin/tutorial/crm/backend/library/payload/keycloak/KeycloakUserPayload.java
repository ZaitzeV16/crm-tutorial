package com.vaadin.tutorial.crm.backend.library.payload.keycloak;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KeycloakUserPayload {
    private String keycloakId;
    private String firstName;
    private String lastName;
    private String userName;
    private List<String> roles = new ArrayList<>();
}
