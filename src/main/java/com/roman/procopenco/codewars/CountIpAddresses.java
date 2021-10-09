package com.roman.procopenco.codewars;

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
