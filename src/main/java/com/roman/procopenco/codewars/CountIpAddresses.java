package com.roman.procopenco.codewars;

/**
 * Implement a function that receives two IPv4 addresses, and returns the number of addresses between them (including the first one, excluding the last one).
 *
 * All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the first one.
 *
 * Examples
 * ips_between("10.0.0.0", "10.0.0.50")  ==   50
 * ips_between("10.0.0.0", "10.0.1.0")   ==  256
 * ips_between("20.0.0.10", "20.0.1.0")  ==  246
 *
 * https://www.codewars.com/kata/526989a41034285187000de4/train/java
 */

public class CountIpAddresses {
  public static long ipsBetween(String start, String end) {

    String[] startIpParts = start.split("\\.");
    String[] endIpParts = end.split("\\.");

    int ipsBetween = 0;
    for (int i = 0; i < endIpParts.length; i++) {
      Integer endIpNum = Integer.valueOf(endIpParts[i]);
      Integer startIpNum = Integer.valueOf(startIpParts[i]);

      if ( endIpNum >= startIpNum) {
        ipsBetween += (endIpNum - startIpNum) * Math.pow(256, endIpParts.length - i - 1);
      } else {
        ipsBetween -= (startIpNum - endIpNum) * Math.pow(256, endIpParts.length - i - 1);
      }
    }

    return ipsBetween;
  }
}
