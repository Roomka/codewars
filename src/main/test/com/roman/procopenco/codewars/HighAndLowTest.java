package com.roman.procopenco.codewars;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;

import static org.junit.Assert.*;

public class HighAndLowTest extends BenchmarkUtility {

    @Benchmark
    @Test
    public void highAndLow() {
        assertEquals("42 -9", HighAndLow.HighAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
}