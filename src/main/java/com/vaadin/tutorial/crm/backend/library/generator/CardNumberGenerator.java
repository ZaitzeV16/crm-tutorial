package com.vaadin.tutorial.crm.backend.library.generator;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

@Component
public class CardNumberGenerator {

    public static final String[] PREFIX_LIST = new String[]{
            "51", "52", "53", "54", "55", "2221", "2222", "2223", "2224", "2225", "2226", "2227", "2228", "2229",
            "223", "224", "225", "226", "227", "228", "229", "23", "24", "25", "26", "270", "271", "2720"
    };

    private String strRev(String str) {
        if (str == null) {
            return "";
        }

        StringBuilder revStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            revStr.append(str.charAt(i));
        }

        return revStr.toString();
    }

    /**
     * 'prefix' is the start of the CC number as a string, any number of digits.
     * 'length' is the length of the CC number to generate. Typically 13 or 16
     */
    private String completed_number(String prefix, int length) {
        StringBuilder ccNumber = new StringBuilder(prefix);

        // generate digits
        while (ccNumber.length() < (length - 1)) {
            double floor = Math.floor(Math.random() * 10);
            ccNumber.append((int) floor);
        }

        // reverse number and convert to int
        String reversedCCNumberString = strRev(ccNumber.toString());

        List<Integer> reversedCCNumberList = new Vector<>();
        for (int i = 0; i < reversedCCNumberString.length(); i++) {
            String s = String.valueOf(reversedCCNumberString.charAt(i));
            reversedCCNumberList.add(Integer.valueOf(s));
        }

        // calculate sum
        int sum = 0;
        int pos = 0;

        Integer[] reversedCCNumber = reversedCCNumberList.toArray(new Integer[reversedCCNumberList.size()]);
        while (pos < length - 1) {
            int odd = reversedCCNumber[pos] * 2;
            if (odd > 9) {
                odd -= 9;
            }

            sum += odd;

            if (pos != (length - 2)) {
                sum += reversedCCNumber[pos + 1];
            }
            pos += 2;
        }

        // calculate check digit
        double toRefactor = ((Math.floor(sum / 10) + 1) * 10 - sum) % 10;
        int checkDigit = Double.valueOf(toRefactor).intValue();
        ccNumber.append(checkDigit);

        return ccNumber.toString();
    }

    private String[] credit_card_number(String[] prefixList, int length, int howMany) {
        Stack<String> result = new Stack<>();

        for (int i = 0; i < howMany; i++) {
            int randomArrayIndex = (int) Math.floor(Math.random() * prefixList.length);
            String ccNumber = prefixList[randomArrayIndex];
            result.push(completed_number(ccNumber, length));
        }

        return result.toArray(new String[result.size()]);
    }

    public String generateCardNumber() {
        return credit_card_number(PREFIX_LIST, 16, 1)[0];
    }

    public boolean isValidCreditCardNumber(String creditCardNumber) {
        boolean isValid = false;

        try {
            String reversedNumber = new StringBuffer(creditCardNumber).reverse().toString();
            int mod10Count = 0;
            for (int i = 0; i < reversedNumber.length(); i++) {
                int augend = Integer.parseInt(String.valueOf(reversedNumber.charAt(i)));

                if (((i + 1) % 2) == 0) {
                    String productString = String.valueOf(augend * 2);
                    augend = 0;
                    for (int j = 0; j < productString.length(); j++) {
                        augend += Integer.parseInt(String.valueOf(productString.charAt(j)));
                    }
                }

                mod10Count += augend;
            }

            if ((mod10Count % 10) == 0) {
                isValid = true;
            }
        } catch (NumberFormatException ignored) {
        }

        return isValid;
    }

}
