package com.vaadin.tutorial.crm.backend.library.base.blackMagic.filterer;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.ReadProcess;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.Filterer;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate.SearchFilter;
import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.filter.predicate.SearchOperation;

import java.util.ArrayList;
import java.util.List;

public class FiltererOperation<MODEL, DTO> implements SingletonOperation<MODEL, DTO>, BlockOperation<MODEL, DTO> {
    private SearchFilter searchFilter;
    private String dtoClassSimpleName;
    private List<SearchFilter> filters;
    private List<List<SearchFilter>> andFilters;
    private List<List<List<SearchFilter>>> orFilters;
    private int layerCount = 2;


    public FiltererOperation(String dtoClassName) {
        this.dtoClassSimpleName = dtoClassName;
        filters = new ArrayList<>();
        andFilters = new ArrayList<>();
        orFilters = new ArrayList<>();
    }

    @Override
    public SingletonOperation<MODEL, DTO> and() {
        this.addAndBlock();
        return this;
    }

    @Override
    public SingletonOperation<MODEL, DTO> or() {
        this.addSearchFilter();
        return this;
    }

    @Override
    public SingletonOperation<MODEL, DTO> orBlock() {
        this.addOrBlock();
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> greaterThan(String fieldName, Object value) {
        this.createSearchFilter(fieldName, value, SearchOperation.GREATER_THAN);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> lessThan(String fieldName, Object value) {
        this.createSearchFilter(fieldName, value, SearchOperation.LESS_THAN);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> greaterThanEqual(String fieldName, Object value) {
        this.createSearchFilter(fieldName, value, SearchOperation.GREATER_THAN_EQUAL);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> lessThanEqual(String fieldName, Object value) {
        this.createSearchFilter(fieldName, value, SearchOperation.LESS_THAN_EQUAL);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> notEqual(String fieldName, Object value) {

        this.createSearchFilter(fieldName, value, SearchOperation.NOT_EQUAL);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> equal(String fieldName, Object value) {

        this.createSearchFilter(fieldName, value, SearchOperation.EQUAL);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> isNull(String fieldName) {
        this.createSearchFilter(fieldName, "", SearchOperation.IS_NULL);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> isNotNull(String fieldName) {
        this.createSearchFilter(fieldName, "", SearchOperation.IS_NOT_NULL);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> match(String fieldName, Object value) {
        this.createSearchFilter(fieldName, value, SearchOperation.MATCH);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> matchStart(String fieldName, Object value) {
        this.createSearchFilter(fieldName, value, SearchOperation.MATCH_START);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> matchEnd(String fieldName, Object value) {
        this.createSearchFilter(fieldName, value, SearchOperation.MATCH_END);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> notMatch(String fieldName, Object value) {
        this.createSearchFilter(fieldName, value, SearchOperation.NOT_MATCH);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> matchNotStart(String fieldName, Object value) {
        this.createSearchFilter(fieldName, value, SearchOperation.MATCH_NOT_START);
        return this;
    }

    @Override
    public BlockOperation<MODEL, DTO> matchNotEnd(String fieldName, Object value) {
        this.createSearchFilter(fieldName, value, SearchOperation.MATCH_NOT_END);
        return this;
    }

    @Override
    public List<DTO> find(ReadProcess readProcess) {
        if (this.filters.size() > 0 || this.andFilters.size() > 0 || this.orFilters.size() > 0) {
            this.addOrBlock();
        }
        Filterer<MODEL, DTO> filterer = new Filterer<>(this.orFilters, this.dtoClassSimpleName, null, null);
        return filterer.findAllByFilter(readProcess);
    }

    private void createSearchFilter(String fieldName, Object value, SearchOperation searchOperation) {
        if (this.searchFilter != null) {
            throw new RuntimeException("U didn't use operation");
        }
        this.searchFilter = new SearchFilter(fieldName, searchOperation, value.toString());
    }

    private void addOrBlock() {
        this.addAndBlock();
        this.orFilters.add(this.andFilters);
        this.andFilters = new ArrayList<>();
        this.filters = new ArrayList<>();
        this.searchFilter = null;
    }

    private void addAndBlock() {
        this.addSearchFilter();
        this.andFilters.add(filters);
        this.filters = new ArrayList<>();
        this.searchFilter = null;
    }

    private void addSearchFilter() {
        this.filters.add(this.searchFilter);
        this.searchFilter = null;
    }
}
