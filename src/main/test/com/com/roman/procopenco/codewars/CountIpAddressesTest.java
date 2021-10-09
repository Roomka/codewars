package com.roman.procopenco.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountIpAddressesTest {

  @Test
  public void ipsBetween() throws Exception {
    assertEquals( 50, CountIpAddresses.ipsBetween( "10.0.0.0", "10.0.0.50" ) );
    assertEquals( 246, CountIpAddresses.ipsBetween( "20.0.0.10", "20.0.1.0" ) );
  }

  @Test
  public void ipsBetweenOptimized() throws Exception {
    assertEquals( 50, CountIpAddresses.ipsBetweenOptimized( "10.0.0.0", "10.0.0.50" ) );
    assertEquals( 246, CountIpAddresses.ipsBetweenOptimized( "20.0.0.10", "20.0.1.0" ) );
  }
}