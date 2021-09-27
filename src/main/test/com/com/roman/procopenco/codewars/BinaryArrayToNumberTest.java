package com.roman.procopenco.codewars;

import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class BinaryArrayToNumberTest extends BenchmarkUtility {

    @Test
    @Benchmark
    public void ConvertBinaryArrayToIntLoop() throws  Exception {
        assertEquals(1, BinaryArrayToNumber.ConvertBinaryArrayToIntLoop(new ArrayList<>(Arrays.asList(0,0,0,1))));
        assertEquals(15, BinaryArrayToNumber.ConvertBinaryArrayToIntLoop(new ArrayList<>(Arrays.asList(1,1,1,1))));
        assertEquals(6, BinaryArrayToNumber.ConvertBinaryArrayToIntLoop(new ArrayList<>(Arrays.asList(0,1,1,0))));
        assertEquals(9, BinaryArrayToNumber.ConvertBinaryArrayToIntLoop(new ArrayList<>(Arrays.asList(1,0,0,1))));
        assertEquals(0, BinaryArrayToNumber.ConvertBinaryArrayToIntLoop(new ArrayList<>(Arrays.asList(0,0,0,0))));

    }

    @Test
    @Benchmark
    public void ConvertBinaryArrayToIntStream() throws  Exception {
        assertEquals(1, BinaryArrayToNumber.ConvertBinaryArrayToIntStream(new ArrayList<>(Arrays.asList(0,0,0,1))));
        assertEquals(15, BinaryArrayToNumber.ConvertBinaryArrayToIntStream(new ArrayList<>(Arrays.asList(1,1,1,1))));
        assertEquals(6, BinaryArrayToNumber.ConvertBinaryArrayToIntStream(new ArrayList<>(Arrays.asList(0,1,1,0))));
        assertEquals(9, BinaryArrayToNumber.ConvertBinaryArrayToIntStream(new ArrayList<>(Arrays.asList(1,0,0,1))));
        assertEquals(0, BinaryArrayToNumber.ConvertBinaryArrayToIntStream(new ArrayList<>(Arrays.asList(0,0,0,0))));

    }


    @Test
    @Benchmark
    public void convertBinaryArrayToInt() throws  Exception {
        assertEquals(1, BinaryArrayToNumber.ConvertBinaryArrayToIntBitwiseOperator(new ArrayList<>(Arrays.asList(0,0,0,1))));
        assertEquals(15, BinaryArrayToNumber.ConvertBinaryArrayToIntBitwiseOperator(new ArrayList<>(Arrays.asList(1,1,1,1))));
        assertEquals(6, BinaryArrayToNumber.ConvertBinaryArrayToIntBitwiseOperator(new ArrayList<>(Arrays.asList(0,1,1,0))));
        assertEquals(9, BinaryArrayToNumber.ConvertBinaryArrayToIntBitwiseOperator(new ArrayList<>(Arrays.asList(1,0,0,1))));
        assertEquals(0, BinaryArrayToNumber.ConvertBinaryArrayToIntBitwiseOperator(new ArrayList<>(Arrays.asList(0,0,0,0))));

    }
}