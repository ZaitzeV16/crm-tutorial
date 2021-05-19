package com.vaadin.tutorial.crm.backend.library.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValuePayload<TYPE> {

    private TYPE value;

}
