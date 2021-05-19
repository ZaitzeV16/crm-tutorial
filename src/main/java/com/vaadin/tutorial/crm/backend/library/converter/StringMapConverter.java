package com.vaadin.tutorial.crm.backend.library.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

@Converter
public class StringMapConverter implements AttributeConverter<Map<String, String>, String> {

    private static final String MAP_DELIMITER = ":";
    private static final String MAP_SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(Map<String, String> stringMap) {
        if (stringMap == null || stringMap.isEmpty()) {
            return "";
        }

        return stringMap.entrySet().stream().
                map(this::convertStringStringMapEntryToString).
                collect(joining(MAP_SEPARATOR));
    }

    private String convertStringStringMapEntryToString(Map.Entry<String, String> entrySet) {
        return entrySet.getKey() + MAP_DELIMITER + entrySet.getValue();
    }

    @Override
    public Map<String, String> convertToEntityAttribute(String string) {
        if (string == null || string.isEmpty()) {
            return new HashMap<>();
        }
        return Arrays.stream(string.split(MAP_SEPARATOR))
                .map(s -> s.split(MAP_DELIMITER))
                .collect(toMap(
                        s -> s[0],
                        s -> (s.length < 2 ? "" : s[1])
                ));
    }

}
