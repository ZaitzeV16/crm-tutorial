package com.vaadin.tutorial.crm.backend.library.base.blackMagic.filterer;

import com.vaadin.tutorial.crm.backend.library.base.blackMagic.read.ReadProcess;

import java.util.List;

public interface SingletonOperation<MODEL, DTO> {
    BlockOperation<MODEL, DTO> greaterThan(String fieldName, Object value);

    BlockOperation<MODEL, DTO> lessThan(String fieldName, Object value);

    BlockOperation<MODEL, DTO> greaterThanEqual(String fieldName, Object value);

    BlockOperation<MODEL, DTO> lessThanEqual(String fieldName, Object value);

    BlockOperation<MODEL, DTO> notEqual(String fieldName, Object value);

    BlockOperation<MODEL, DTO> equal(String fieldName, Object value);

    BlockOperation<MODEL, DTO> isNull(String fieldName);

    BlockOperation<MODEL, DTO> isNotNull(String fieldName);

    BlockOperation<MODEL, DTO> match(String fieldName, Object value);

    BlockOperation<MODEL, DTO> matchStart(String fieldName, Object value);

    BlockOperation<MODEL, DTO> matchEnd(String fieldName, Object value);

    BlockOperation<MODEL, DTO> notMatch(String fieldName, Object value);

    BlockOperation<MODEL, DTO> matchNotStart(String fieldName, Object value);

    BlockOperation<MODEL, DTO> matchNotEnd(String fieldName, Object value);

//    BlockOperation<MODEL, DTO>  in(String fieldName, Object value);
//
//    BlockOperation<MODEL, DTO>  notIn(String fieldName, Object value);

    List<DTO> find(ReadProcess readProcess);
}
