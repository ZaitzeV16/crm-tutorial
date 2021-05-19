package com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.ReadProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate.OrderByFilter;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate.SearchFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GETPayload {

    private String dtoType;
    private List<List<List<SearchFilter>>> filters = new ArrayList<>();
    private List<String> groupByAttributes = new ArrayList<>();
    private List<OrderByFilter> orderByFilters = new ArrayList<>();

    private <MODEL, DTO> Filterer<MODEL, DTO> getFilterer() {
        return new Filterer<>(
                this.filters,
                this.dtoType,
                this.groupByAttributes,
                this.orderByFilters
        );
    }

    @SuppressWarnings("unchecked")
    public <DTO> List<DTO> findAllByFilter(ReadProcess readProcess) {
        return getFilterer().findAllByFilter(readProcess);
    }

}
