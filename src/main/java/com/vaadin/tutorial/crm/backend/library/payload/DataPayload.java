package com.vaadin.tutorial.crm.backend.library.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DataPayload<ATTRIBUTE> {

    private String type;
    private int id;
    private String token = "";

    @Valid
    private ATTRIBUTE attribute;

    public DataPayload(@Valid ATTRIBUTE attribute) {
        this.attribute = attribute;
    }

    public DataPayload(int id, String type, @Valid ATTRIBUTE attribute) {
        this.type = type;
        this.id = id;
        this.attribute = attribute;
    }

}
