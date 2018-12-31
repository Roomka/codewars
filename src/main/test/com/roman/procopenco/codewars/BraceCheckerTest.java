package com.roman.procopenco.codewars;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;

import static org.junit.Assert.*;

public class BraceCheckerTest extends  BenchmarkUtility {


    @Benchmark
    @Test
    public void testValid() {
        assertEquals(false, BraceChecker.isValid("((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("));
    }
    @Benchmark
    @Test
    public void testInvalid() {
        assertEquals(false, BraceChecker.isValid("[(])"));
    }

    @Benchmark
    @Test
    public void testValid2_1() {
        assertEquals(false, BraceChecker.isValid2("((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("));
    }

    @Benchmark
    @Test
    public void testInvalid2_2() {
        assertEquals(false, BraceChecker.isValid2("[(])"));
    }
}