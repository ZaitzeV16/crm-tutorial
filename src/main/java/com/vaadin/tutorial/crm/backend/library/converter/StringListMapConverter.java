package com.vaadin.tutorial.crm.backend.library.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Converter
public class StringListMapConverter implements AttributeConverter<List<Map<String, String>>, String> {

    private static final String SPLIT_CHAR = ";";
    private static final String MAP_DELIMITER = ":";
    private static final String MAP_SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(List<Map<String, String>> stringListMap) {
        if (stringListMap == null || stringListMap.isEmpty()) {
            return "";
        }

        return stringListMap.stream()
                .map(this::convertStringStringMapToString)
                .collect(joining((SPLIT_CHAR)));
    }

    private String convertStringStringMapToString(Map<String, String> stringStringMap) {
        return stringStringMap.entrySet().stream()
                .map(this::convertStringStringMapEntryToString)
                .collect(joining(MAP_SEPARATOR));
    }

    private String convertStringStringMapEntryToString(Map.Entry<String, String> entrySet) {
        return entrySet.getKey() + MAP_DELIMITER + entrySet.getValue();
    }

    @Override
    public List<Map<String, String>> convertToEntityAttribute(String string) {
        if (string == null || string.isEmpty()) {
            return new ArrayList<>();
        }

        return Arrays.stream(string.split(SPLIT_CHAR))
                .map(keyValue -> Arrays.stream(keyValue.split(MAP_SEPARATOR))
                        .map(s -> s.split(MAP_DELIMITER))
                        .collect(toMap(
                                s -> s[0],
                                s -> s[1])))
                .collect(toList());
    }

}
