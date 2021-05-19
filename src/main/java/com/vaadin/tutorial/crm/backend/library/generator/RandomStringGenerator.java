package com.vaadin.tutorial.crm.backend.library.generator;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

@Component
public class RandomStringGenerator {

    public static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER = UPPER.toLowerCase(Locale.ROOT);
    public static final String DIGITS = "0123456789";
    public static final String ALPHA_NUM = UPPER + LOWER + DIGITS;

    private final Random random = new SecureRandom();

    public String generateString(int length) {
        return this.generateString(length, ALPHA_NUM);
    }

    public String generateString(int length, String symbolsString) {
        char[] symbols = symbolsString.toCharArray();
        char[] buf = new char[length];

        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];

        return new String(buf);
    }

}