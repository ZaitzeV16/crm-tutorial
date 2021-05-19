package com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchFilter {

    private String modelFieldName;
    private SearchOperation operation;
    private String filterValue;

}
