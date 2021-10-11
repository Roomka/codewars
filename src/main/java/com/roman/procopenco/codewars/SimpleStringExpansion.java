package com.roman.procopenco.codewars;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Consider the following expansion:
 *
 * solve("3(ab)") = "ababab"     -- because "ab" repeats 3 times
 * solve("2(a3(b))") = "abbbabbb" -- because "a3(b)" == "abbb", which repeats twice.
 * Given a string, return the expansion of that string.
 *
 * Input will consist of only lowercase letters and numbers (1 to 9) in valid parenthesis. There will be no letters or numbers after the last closing parenthesis.
 *
 * More examples in test cases.
 *
 * Good luck!
 *
 * Please also try Simple time difference
 */
public class SimpleStringExpansion {

  public static String solves(String s){
    String new_s = "";
    for(char ch : new StringBuilder(s).reverse().toString().toCharArray()) {
      if(Character.isDigit(ch)) new_s = new_s.repeat(Integer.parseInt(ch + ""));
      if(Character.isLetter(ch)) new_s = ch + new_s;
    }
    return new_s;
  }

}
