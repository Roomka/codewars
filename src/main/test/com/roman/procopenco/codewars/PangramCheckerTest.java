package com.roman.procopenco.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class PangramCheckerTest {

    @Test
    public void test1Regular() {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        PangramChecker pc = new PangramChecker();
        assertEquals(true, pc.check(pangram1));
    }
    @Test
    public void test2Regular() {
        String pangram2 = "You shall not pass!";
        PangramChecker pc = new PangramChecker();
        assertEquals(false, pc.check(pangram2));
    }

    @Test
    public void test1Stream1() {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        PangramChecker pc = new PangramChecker();
        assertEquals(true, pc.checkStream1(pangram1));
    }
    @Test
    public void test2Stream1() {
        String pangram2 = "You shall not pass!";
        PangramChecker pc = new PangramChecker();
        assertEquals(false, pc.checkStream1(pangram2));
    }

    @Test
    public void test1Stream2() {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        PangramChecker pc = new PangramChecker();
        assertEquals(true, pc.checkStream2(pangram1));
    }
    @Test
    public void test2Stream2() {
        String pangram2 = "You shall not pass!";
        PangramChecker pc = new PangramChecker();
        assertEquals(false, pc.checkStream2(pangram2));
    }
}