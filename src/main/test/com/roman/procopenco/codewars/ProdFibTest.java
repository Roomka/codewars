package com.roman.procopenco.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProdFibTest extends BenchmarkUtility {

    @Test
    public void test1() {
        long[] r = new long[] {55, 89, 1};
        assertArrayEquals(r, ProdFib.productFib(4895));
    }
    @Test
    public void test2() {
        long[] r = new long[] {89, 144, 0};
        assertArrayEquals(r, ProdFib.productFib(5895));
    }

    @Test
    public void test3() {
        long[] r = new long[] {1, 1, 1};
        assertArrayEquals(r, ProdFib.productFib(1));
    }
}