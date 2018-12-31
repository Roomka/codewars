package com.roman.procopenco.codewars;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class YourOrderPleaseTest extends BenchmarkUtility {
    @Benchmark
    @Test
    public void testOrderImperative1_1() {
        assertThat(YourOrderPlease.orderImperative1("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
    }

    @Benchmark
    @Test
    public void testOrderImperative1_2() {                       //Fo1r g3ood 4of th5e pe6ople
        assertThat(YourOrderPlease.orderImperative1("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    @Benchmark
    @Test
    public void testOrderImperative1_3() {
        assertThat("Empty input should return empty string", YourOrderPlease.orderImperative1(""), equalTo(""));
    }

    @Benchmark
    @Test
    public void testOrderImperative2_1() {
        assertThat(YourOrderPlease.orderImperative2("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
    }

    @Benchmark
    @Test
    public void testOrderImperative2_2() {                       //Fo1r g3ood 4of th5e pe6ople
        assertThat(YourOrderPlease.orderImperative2("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    @Benchmark
    @Test
    public void testOrderImperative2_3() {
        assertThat("Empty input should return empty string", YourOrderPlease.orderImperative2(""), equalTo(""));
    }

    @Benchmark
    @Test
    public void testOrderStream_1() {
        assertThat(YourOrderPlease.orderStream("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
    }

    @Benchmark
    @Test
    public void testOrderStream_2() {                       //Fo1r g3ood 4of th5e pe6ople
        assertThat(YourOrderPlease.orderStream("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    @Benchmark
    @Test
    public void testOrderStream_3() {
        assertThat("Empty input should return empty string", YourOrderPlease.orderStream(""), equalTo(""));
    }
}