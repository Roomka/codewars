package com.roman.procopenco.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProdFibTest {

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
    public void testOptimized1() {
        long[] r = new long[] {55, 89, 1};
        assertArrayEquals(r, ProdFib.productFibOptimized(4895));
    }
    @Test
    public void testOptimized2() {
        long[] r = new long[] {89, 144, 0};
        assertArrayEquals(r, ProdFib.productFibOptimized(5895));
    }
}