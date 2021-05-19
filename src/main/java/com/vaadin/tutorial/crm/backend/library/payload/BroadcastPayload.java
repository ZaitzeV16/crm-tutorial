package com.vaadin.tutorial.crm.backend.library.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BroadcastPayload {

    private String type;
    private String subscribePath;
    private Object attribute;

}
