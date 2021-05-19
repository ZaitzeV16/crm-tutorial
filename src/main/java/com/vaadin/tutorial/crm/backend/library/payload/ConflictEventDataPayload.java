package com.vaadin.tutorial.crm.backend.library.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ConflictEventDataPayload<T> extends DataPayload<T> {

    private Map<Object, Object> eventData;

}
