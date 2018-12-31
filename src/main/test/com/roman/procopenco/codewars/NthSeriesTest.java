package com.roman.procopenco.codewars;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;

import static org.junit.Assert.*;

public class NthSeriesTest extends BenchmarkUtility {


    @Benchmark
    @Test
    public void testseriesSumImperative() {
        assertEquals("2.30", NthSeries.seriesSumImperative(44));
    }

    @Benchmark
    @Test
    public void testSeriesSumStream() {
        assertEquals("2.30", NthSeries.seriesSumStream(44));
    }


    @Benchmark
    @Test
    public void testSeriesSumPersonal() {
        assertEquals("2.30", NthSeries.seriesSumPersonal(44));
    }





}