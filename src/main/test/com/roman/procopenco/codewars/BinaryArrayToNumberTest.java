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

public class BinaryArrayToNumberTest {

    @Test public void
    launchBenchmark() throws Exception {

        Options opt = new OptionsBuilder()
                // Specify which benchmarks to run.
                // You can be more specific if you'd like to run only one benchmark per test.
                .include(this.getClass().getName() + ".*")
                // Set the following options as needed
                .mode (Mode.AverageTime)
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(2)
                .measurementTime(TimeValue.seconds(1))
                .measurementIterations(2)
                .threads(2)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                //.jvmArgs("-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintInlining")
                //.addProfiler(WinPerfAsmProfiler.class)
                .build();

        new Runner(opt).run();
    }

    // The JMH samples are the best documentation for how to use it
    // http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/
    @State(Scope.Thread)
    public static class BenchmarkState
    {
        List<Integer> list;

        @Setup(Level.Trial) public void
        initialize() {

            Random rand = new Random();

            list = new ArrayList<>();
            for (int i = 0; i < 1000; i++)
                list.add (rand.nextInt());
        }
    }

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