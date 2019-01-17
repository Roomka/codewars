package com.roman.procopenco.codewars;

public class ValidPhoneNumber {

    /**
     * https://www.codewars.com/kata/valid-phone-number/java
     * @param phoneNumber
     * @return
     */

    public static boolean validPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}");
    }

}
