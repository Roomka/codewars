package com.roman.procopenco.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DoubleLinearTest {

  private static void testing(int actual, int expected) {
    assertEquals(expected, actual);
  }

  @Test
  public void test() {
    System.out.println("Fixed Tests dblLinear");
    testing(DoubleLinear.dblLinear3(10), 22);
    testing(DoubleLinear.dblLinear3(20), 57);
    testing(DoubleLinear.dblLinear3(30), 91);
    testing(DoubleLinear.dblLinear3(50), 175);
    testing(DoubleLinear.dblLinear3(100), 447);
  }
}