package com.roman.procopenco.codewars;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;
import org.junit.Test;

public class SimpleStringExpansionTest {
  @Test
  public void basicTests(){
    assertEquals("ababab",SimpleStringExpansion.solves("3(ab)"));
    assertEquals("abbbabbb",SimpleStringExpansion.solves("2(a3(b))"));
    assertEquals("bccbccbcc",SimpleStringExpansion.solves("3(b(2(c)))"));
    assertEquals("kabaccbaccbacc",SimpleStringExpansion.solves("k(a3(b(a2(c))))"));
  }
}