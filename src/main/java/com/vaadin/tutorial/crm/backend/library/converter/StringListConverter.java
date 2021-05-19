package com.vaadin.tutorial.crm.backend.library.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    private static final String SPLIT_CHAR = ";";

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        return (stringList == null || stringList.isEmpty())
                ? ""
                : String.join(SPLIT_CHAR, stringList);
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        return (string == null || string.isBlank())
                ? new ArrayList<>()
                : new ArrayList<>(Arrays.asList(string.split(SPLIT_CHAR)));
    }

}
