package com.roman.procopenco.codewars;

/**
 * https://www.codewars.com/kata/valid-phone-number/java </br> <br/>
 * Write a function that accepts a string, and returns true if it is in the form of a phone number. <br/>
 * Assume that any integer from 0-9 in any of the spots will produce a valid phone number.<br/> <br/>
 *
 * Only worry about the following format: <br/>
 * (123) 456-7890 (don't forget the space after the close parentheses) <br/> <br/>
 *
 * Examples: <br/>
 *
 * validPhoneNumber("(123) 456-7890")  =>  returns true <br/>
 * validPhoneNumber("(1111)555 2345")  => returns false <br/>
 * validPhoneNumber("(098) 123 4567")  => returns false <br/>
 *
 */

public class ValidPhoneNumber {

    /**
     * Checks if the passed number is valid or not,based on the regular expression.
     * @param phoneNumber
     * @return
     */

    public static boolean validPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}");
    }

}
