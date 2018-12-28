package com.roman.procopenco.codewars;

import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class DuplicateEncoderTest {

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


    @Benchmark
    @Test
    public void encodeHashMap() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encodeHashMap("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encodeHashMap("   ()(   "));
        assertEquals(
                ")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))()))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))"
                ,DuplicateEncoder.encodeHashMap("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel efficitur ex, eget dictum turpis. Integer ut nisl diam. Curabitur malesuada justo et sagittis eleifend. Nulla id elementum purus. Aenean quam leo, imperdiet quis tincidunt in, elementum in enim. Curabitur dictum mollis odio lobortis egestas. Sed quis gravida velit, ac sodales felis. Proin sed tincidunt nisl, at tristique sapien. Ut varius semper porttitor. Mauris fringilla purus magna, ut dictum lorem convallis sit amet. Donec mattis arcu a consectetur mattis. Curabitur vel arcu vitae massa dignissim iaculis non in magna. Duis feugiat et leo sed blandit. Praesent feugiat eros sed elit venenatis, quis efficitur erat ornare. Ut pharetra, quam elementum vulputate suscipit, neque eros blandit sem, nec scelerisque elit magna efficitur mi."));
    }

    @Benchmark
    @Test
    public void encodeLastIndexOf() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encodeLastIndexOf("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encodeLastIndexOf("   ()(   "));
        assertEquals(
                ")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))()))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))"
                ,DuplicateEncoder.encodeLastIndexOf("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel efficitur ex, eget dictum turpis. Integer ut nisl diam. Curabitur malesuada justo et sagittis eleifend. Nulla id elementum purus. Aenean quam leo, imperdiet quis tincidunt in, elementum in enim. Curabitur dictum mollis odio lobortis egestas. Sed quis gravida velit, ac sodales felis. Proin sed tincidunt nisl, at tristique sapien. Ut varius semper porttitor. Mauris fringilla purus magna, ut dictum lorem convallis sit amet. Donec mattis arcu a consectetur mattis. Curabitur vel arcu vitae massa dignissim iaculis non in magna. Duis feugiat et leo sed blandit. Praesent feugiat eros sed elit venenatis, quis efficitur erat ornare. Ut pharetra, quam elementum vulputate suscipit, neque eros blandit sem, nec scelerisque elit magna efficitur mi."));

    }

    @Benchmark
    @Test
    public void encodeStream() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encodeStream("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encodeStream("   ()(   "));
        assertEquals(
                ")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))()))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))"
                ,DuplicateEncoder.encodeStream("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel efficitur ex, eget dictum turpis. Integer ut nisl diam. Curabitur malesuada justo et sagittis eleifend. Nulla id elementum purus. Aenean quam leo, imperdiet quis tincidunt in, elementum in enim. Curabitur dictum mollis odio lobortis egestas. Sed quis gravida velit, ac sodales felis. Proin sed tincidunt nisl, at tristique sapien. Ut varius semper porttitor. Mauris fringilla purus magna, ut dictum lorem convallis sit amet. Donec mattis arcu a consectetur mattis. Curabitur vel arcu vitae massa dignissim iaculis non in magna. Duis feugiat et leo sed blandit. Praesent feugiat eros sed elit venenatis, quis efficitur erat ornare. Ut pharetra, quam elementum vulputate suscipit, neque eros blandit sem, nec scelerisque elit magna efficitur mi."));

    }

    @Benchmark
    @Test
    public void encodeHashpMapOptimized() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encodeHashpMapOptimized("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encodeHashpMapOptimized("   ()(   "));
        assertEquals(
                ")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))()))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))"
                ,DuplicateEncoder.encodeHashpMapOptimized("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel efficitur ex, eget dictum turpis. Integer ut nisl diam. Curabitur malesuada justo et sagittis eleifend. Nulla id elementum purus. Aenean quam leo, imperdiet quis tincidunt in, elementum in enim. Curabitur dictum mollis odio lobortis egestas. Sed quis gravida velit, ac sodales felis. Proin sed tincidunt nisl, at tristique sapien. Ut varius semper porttitor. Mauris fringilla purus magna, ut dictum lorem convallis sit amet. Donec mattis arcu a consectetur mattis. Curabitur vel arcu vitae massa dignissim iaculis non in magna. Duis feugiat et leo sed blandit. Praesent feugiat eros sed elit venenatis, quis efficitur erat ornare. Ut pharetra, quam elementum vulputate suscipit, neque eros blandit sem, nec scelerisque elit magna efficitur mi."));

    }






}