package com.vaadin.tutorial.crm.backend.library;

//import com.google.gson.*;
//import com.google.gson.reflect.TypeToken;
import com.vaadin.tutorial.crm.backend.library.exception.ConflictException;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public abstract class Utilities {

    private static final Map<Class<?>, BiFunction<Object, Object, Boolean>> EQUALS_MAP = Map.of(
            Integer.class, (o, o2) -> com.vaadin.tutorial.crm.backend.library.Utilities.equals((Integer) o, (Integer) o2),
            Double.class, (o, o2) -> com.vaadin.tutorial.crm.backend.library.Utilities.equals((Double) o, (Double) o2),
            Long.class, (o, o2) -> com.vaadin.tutorial.crm.backend.library.Utilities.equals((Long) o, (Long) o2),
            String.class, (o, o2) -> com.vaadin.tutorial.crm.backend.library.Utilities.equals((String) o, (String) o2)
    );

    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String DATE_TIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    public static final String PINA_PONT_HU = "yyyy-MM-dd_HH_mm_ss";
    public static final DateTimeFormatter MAJDNEM_PINA = DateTimeFormatter.ofPattern(PINA_PONT_HU);

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    public static final DateTimeFormatter DATE_TIME_FILE_NAME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    public static final DateTimeFormatter DATE_TIME_FORMATTER_WITH_T = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

//    private static final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
//        @Override
//        public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//            return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString(), DATE_TIME_FORMATTER_WITH_T);
//        }
//    }).create();


    @SuppressWarnings("unchecked")
    public static <OBJECT> OBJECT[] getArray(OBJECT[] subArray, OBJECT... additionalElements) {
        return (OBJECT[]) Stream
                .concat(Arrays.stream(subArray), Arrays.stream(additionalElements))
                .toArray();
    }

    @SuppressWarnings("unchecked")
    public static <OBJECT> OBJECT[] getArray(OBJECT[]... arrays) {
        return (OBJECT[]) Arrays.stream(arrays)
                .flatMap(Arrays::stream)
                .toArray();
    }

    @SuppressWarnings("unchecked")
    public static <OBJECT> OBJECT[] getArray(OBJECT... elements) {
        return (OBJECT[]) Arrays.stream(elements)
                .toArray();
    }


    // region MapOf
    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1) {
        Map<KEY, Object> result = new HashMap<>();
        result.put(key1, value1);
        return result;
    }

    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1, KEY key2, Object value2) {
        Map<KEY, Object> result = com.vaadin.tutorial.crm.backend.library.Utilities.mapOf(key1, value1);
        result.put(key2, value2);
        return result;
    }

    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1, KEY key2, Object value2, KEY key3, Object value3) {
        Map<KEY, Object> result = com.vaadin.tutorial.crm.backend.library.Utilities.mapOf(key1, value1, key2, value2);
        result.put(key3, value3);
        return result;
    }

    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1, KEY key2, Object value2, KEY key3, Object value3, KEY key4, Object value4) {
        Map<KEY, Object> result = com.vaadin.tutorial.crm.backend.library.Utilities.mapOf(key1, value1, key2, value2, key3, value3);
        result.put(key4, value4);
        return result;
    }

    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1, KEY key2, Object value2, KEY key3, Object value3, KEY key4, Object value4, KEY key5, Object value5) {
        Map<KEY, Object> result = com.vaadin.tutorial.crm.backend.library.Utilities.mapOf(key1, value1, key2, value2, key3, value3, key4, value4);
        result.put(key5, value5);
        return result;
    }

    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1, KEY key2, Object value2, KEY key3, Object value3, KEY key4, Object value4, KEY key5, Object value5, KEY key6, Object value6) {
        Map<KEY, Object> result = com.vaadin.tutorial.crm.backend.library.Utilities.mapOf(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
        result.put(key6, value6);
        return result;
    }

    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1, KEY key2, Object value2, KEY key3, Object value3, KEY key4, Object value4, KEY key5, Object value5, KEY key6, Object value6, KEY key7, Object value7) {
        Map<KEY, Object> result = com.vaadin.tutorial.crm.backend.library.Utilities.mapOf(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6);
        result.put(key7, value7);
        return result;
    }

    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1, KEY key2, Object value2, KEY key3, Object value3, KEY key4, Object value4, KEY key5, Object value5, KEY key6, Object value6, KEY key7, Object value7, KEY key8, Object value8) {
        Map<KEY, Object> result = com.vaadin.tutorial.crm.backend.library.Utilities.mapOf(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7);
        result.put(key8, value8);
        return result;
    }

    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1, KEY key2, Object value2, KEY key3, Object value3, KEY key4, Object value4, KEY key5, Object value5, KEY key6, Object value6, KEY key7, Object value7, KEY key8, Object value8, KEY key9, Object value9) {
        Map<KEY, Object> result = com.vaadin.tutorial.crm.backend.library.Utilities.mapOf(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8);
        result.put(key9, value9);
        return result;
    }

    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1, KEY key2, Object value2, KEY key3, Object value3, KEY key4, Object value4, KEY key5, Object value5, KEY key6, Object value6, KEY key7, Object value7, KEY key8, Object value8, KEY key9, Object value9, KEY key10, Object value10) {
        Map<KEY, Object> result = com.vaadin.tutorial.crm.backend.library.Utilities.mapOf(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8, key9, value9);
        result.put(key10, value10);
        return result;
    }

    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1, KEY key2, Object value2, KEY key3, Object value3, KEY key4, Object value4, KEY key5, Object value5, KEY key6, Object value6, KEY key7, Object value7, KEY key8, Object value8, KEY key9, Object value9, KEY key10, Object value10, KEY key11, Object value11) {
        Map<KEY, Object> result = com.vaadin.tutorial.crm.backend.library.Utilities.mapOf(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8, key9, value9, key10, value10);
        result.put(key11, value11);
        return result;
    }

    public static <KEY> Map<KEY, Object> mapOf(KEY key1, Object value1, KEY key2, Object value2, KEY key3, Object value3, KEY key4, Object value4, KEY key5, Object value5, KEY key6, Object value6, KEY key7, Object value7, KEY key8, Object value8, KEY key9, Object value9, KEY key10, Object value10, KEY key11, Object value11, KEY key12, Object value12) {
        Map<KEY, Object> result = com.vaadin.tutorial.crm.backend.library.Utilities.mapOf(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7, key8, value8, key9, value9, key10, value10, key11, value11);
        result.put(key12, value12);
        return result;
    }
    // endregion MapOf


    // region Math-ish
    public static boolean equals(Object a, Object b) {
        Class<?> aClass = a.getClass();

        if (!aClass.equals(b.getClass())) {
            throw new IllegalArgumentException("Objects' types not match!");
        }

        if (!com.vaadin.tutorial.crm.backend.library.Utilities.EQUALS_MAP.containsKey(aClass)) {
            throw new IllegalArgumentException(com.vaadin.tutorial.crm.backend.library.Utilities.class.getSimpleName() + ".equals cannot handle given Object type!");
        }

        return com.vaadin.tutorial.crm.backend.library.Utilities.EQUALS_MAP.get(aClass).apply(a, b);
    }

    private static boolean equals(Integer a, Integer b) {
        return a.equals(b);
    }

    private static boolean equals(Double a, Double b) {
        return a.equals(b);
    }

    private static boolean equals(Long a, Long b) {
        return a.equals(b);
    }

    private static boolean equals(String a, String b) {
        return a.equals(b);
    }

    public static Double reduceByMultiplication(List<Double> numbers) {
        Double sum = 1D;

        for (Double number : numbers) {
            sum *= number;
        }

        return sum;
    }
    // endregion Math-ish


    // region Date/DateTime
    public static LocalDateTime toLocalDateTime(String dateTimeString) {
        if (dateTimeString.length() != com.vaadin.tutorial.crm.backend.library.Utilities.DATE_TIME_PATTERN.length()) {
            throw new ConflictException("error.dateTimeString.formatMismatch");
        }

        return LocalDateTime.parse(dateTimeString, com.vaadin.tutorial.crm.backend.library.Utilities.DATE_TIME_FORMATTER);
    }

    // TODO: 2020. 11. 10. Zi - rename
    public static LocalDateTime convertStringToLocalDateTime(String dateOrDateTimeString, boolean isStartOfDay) {
        if (dateOrDateTimeString.length() == com.vaadin.tutorial.crm.backend.library.Utilities.DATE_TIME_PATTERN.length()) {
            return LocalDateTime.parse(dateOrDateTimeString, com.vaadin.tutorial.crm.backend.library.Utilities.DATE_TIME_FORMATTER);
        }

        if (isStartOfDay) {
            return LocalDate.parse(dateOrDateTimeString, com.vaadin.tutorial.crm.backend.library.Utilities.DATE_FORMATTER).atStartOfDay();
        }

        return LocalDate.parse(dateOrDateTimeString, com.vaadin.tutorial.crm.backend.library.Utilities.DATE_FORMATTER).atTime(LocalTime.MAX);

//        return (isStartOfDay)
//                ? LocalDate.parse(dateOrDateTimeString, DATE_FORMATTER).atStartOfDay()
//                : LocalDate.parse(dateOrDateTimeString, Utilities.DATE_FORMATTER).atTime(LocalTime.MAX);
    }

    public static boolean isBetween(LocalDateTime target, LocalDateTime intervalStart, LocalDateTime intervalStop) {
        return intervalStart.isBefore(target)
                && intervalStop.isAfter(target);
    }

    public static boolean isBetween(LocalDate target, LocalDate intervalStart, LocalDate intervalStop) {
        return intervalStart.isBefore(target)
                && intervalStop.isAfter(target);
    }

    public static boolean isBetween(LocalTime target, LocalTime intervalStart, LocalTime intervalStop) {
        return intervalStart.isBefore(target)
                && intervalStop.isAfter(target);
    }

    public static LocalDateTime localDateToEndOfDay(LocalDate date) {
        return com.vaadin.tutorial.crm.backend.library.Utilities.convertStringToLocalDateTime(date.toString(), false);
    }

    // TODO: 2020. 11. 10. Zi - rename
    public static LocalDate convertStringToLocalDate(String date) {
        return LocalDate.parse(date, com.vaadin.tutorial.crm.backend.library.Utilities.DATE_FORMATTER);
    }

    // TODO: 2020. 11. 10. Zi - rename
    public static LocalTime convertStringToLocalTime(String date) {
        return LocalTime.parse(date, com.vaadin.tutorial.crm.backend.library.Utilities.TIME_FORMATTER);
    }

    public static boolean isBeforeOrAt(LocalDateTime baseValue, LocalDateTime compareValue, ChronoUnit truncateTo) {
        int comparisonResult = compare(baseValue, compareValue, truncateTo);
        return comparisonResult <= 0;
    }

    public static boolean isAfterOrAt(LocalDateTime baseValue, LocalDateTime compareValue, ChronoUnit truncateTo) {
        int comparisonResult = compare(baseValue, compareValue, truncateTo);
        return comparisonResult >= 0;
    }

    private static int compare(LocalDateTime baseValue, LocalDateTime compareValue, ChronoUnit truncateTo) {
        LocalDateTime truncatedBaseValue = baseValue.truncatedTo(truncateTo);
        LocalDateTime truncatedCompareValue = compareValue.truncatedTo(truncateTo);

        return truncatedBaseValue.compareTo(truncatedCompareValue);
    }
    // endregion Date/DateTime


    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);

        return (double) tmp / factor;
    }

    @SuppressWarnings("unchecked")
    public static Class<? extends Enum<?>> getDtoTypeEnumByEntityClassCanonicalName(String entityCanonicalName) {
        String[] canonicalNameParts = entityCanonicalName.split("\\.");
        int namePartsLength = canonicalNameParts.length;

        canonicalNameParts[namePartsLength - 2] = "dto";

        String dtoTypeEnumSimpleName = canonicalNameParts[namePartsLength - 1] + "DtoType";
        canonicalNameParts[namePartsLength - 1] = dtoTypeEnumSimpleName;

        Class<?> enumClass = com.vaadin.tutorial.crm.backend.library.Utilities.getClassForName(String.join(".", canonicalNameParts));

        return (Class<? extends Enum<?>>) enumClass;
    }

    @SneakyThrows
    public static Class<?> getClassForName(String className) {
        return Class.forName(className);
    }

//    public static <T> T getPayloadFromString(String json, Class<T> type) {
//        return gson.fromJson(json, type);
//    }

    public static String readResponseAsJSONString(InputStreamReader inputStreamReader) throws IOException {
        BufferedReader br = new BufferedReader(inputStreamReader);
        StringBuilder response = new StringBuilder();
        String responseLine;

        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }

        return response.toString();
    }

//    public static <T> T getPayloadFromInputStream(InputStreamReader inputStreamReader, Class<T> type) throws IOException {
//        String json = com.vaadin.tutorial.crm.backend.library.Utilities.readResponseAsJSONString(inputStreamReader);
//        return gson.fromJson(json, type);
//    }
//
//    public static <T> List<T> getPayloadListFromInputStream(InputStreamReader inputStreamReader, Class<T> type) throws IOException {
//        String json = com.vaadin.tutorial.crm.backend.library.Utilities.readResponseAsJSONString(inputStreamReader);
//        Type listType = TypeToken.getParameterized(ArrayList.class, type).getType();
//        return gson.fromJson(json, listType);
//    }

    public static String encodeBase64String(String string) {
        byte[] encode = Base64.getEncoder().encode(string.getBytes());
        return new String(encode);
    }

    public static String decodeBase64String(String encodedString) {
        byte[] decode = Base64.getDecoder().decode(encodedString);
        return new String(decode);
    }


    // region List
    public static <MEMBER> boolean listsEqualUnordered(List<MEMBER> l1, List<MEMBER> l2) {
        if (l1 == l2) {
            return true;
        }

        if (l1.size() != l2.size()) {
            return false;
        }

        List<MEMBER> sortedL1 = l1.stream().sorted().collect(toList());
        List<MEMBER> sortedL2 = l2.stream().sorted().collect(toList());

        for (int i = 0; i < sortedL1.size(); i++) {
            if (!sortedL1.get(i).equals(sortedL2.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static <MEMBER> boolean listsNotEqualUnordered(List<MEMBER> l1, List<MEMBER> l2) {
        return !listsEqualUnordered(l1, l2);
    }
    // endregion List


    // region Set
    public static <MEMBER> boolean setsEqualUnordered(Set<MEMBER> s1, Set<MEMBER> s2) {
        if (s1 == s2) {
            return true;
        }

        if (s1.size() != s2.size()) {
            return false;
        }

        return listsEqualUnordered(new ArrayList<>(s1), new ArrayList<>(s2));
    }

    public static <MEMBER> boolean setsNotEqualUnordered(Set<MEMBER> s1, Set<MEMBER> s2) {
        return !setsEqualUnordered(s1, s2);
    }
    // endregion Set

}
