package com.roman.procopenco.codewars;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;
import org.junit.Test;

public class LongestCommonSubsequenceTest  {
  @Test
  public void exampleTests() {
    assertEquals("", LongestCommonSubsequence.lcs("a", "b"));
    assertEquals("abc", LongestCommonSubsequence.lcs("abcdef", "abc"));
  }
}