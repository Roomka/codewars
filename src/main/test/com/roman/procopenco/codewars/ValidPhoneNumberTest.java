package com.roman.procopenco.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPhoneNumberTest {

    @Test
    public void validPhoneNumber() {
        assertEquals(true, ValidPhoneNumber.validPhoneNumber("(123) 456-7890"));
        assertEquals(false, ValidPhoneNumber.validPhoneNumber("(1111)555 2345"));
        assertEquals(false, ValidPhoneNumber.validPhoneNumber("(098) 123 4567"));

    }
}