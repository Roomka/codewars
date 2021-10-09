package com.roman.procopenco.codewars;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a throw according to these rules. You will always be given an array with five six-sided dice values.
 *
 *  Three 1's => 1000 points
 *  Three 6's =>  600 points
 *  Three 5's =>  500 points
 *  Three 4's =>  400 points
 *  Three 3's =>  300 points
 *  Three 2's =>  200 points
 *  One   1   =>  100 points
 *  One   5   =>   50 point
 * A single die can only be counted once in each roll. For example, a given "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, but not both in the same roll.
 *
 * Example scoring
 *
 *  Throw       Score
 *  ---------   ------------------
 *  5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
 *  1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
 *  2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
 * In some languages, it is possible to mutate the input to the function. This is something that you should never do. If you mutate the input, you will not be able to pass all the tests.
 *
 * https://www.codewars.com/kata/5270d0d18625160ada0000e4/train/java
 */

public class GreedIsGood {
  static Map<Integer, Integer> trippleDigitsMap = new HashMap<>();
  static Map<Integer, Integer> singleDigitsMap = new HashMap<>();

  static {
    trippleDigitsMap.put(1, 1000);
    trippleDigitsMap.put(6, 600);
    trippleDigitsMap.put(5, 500);
    trippleDigitsMap.put(4, 400);
    trippleDigitsMap.put(3, 300);
    trippleDigitsMap.put(2, 200);

    singleDigitsMap.put(1, 100);
    singleDigitsMap.put(5, 50);
  }



  public static int greedy(int[] dice){
    Map<Integer, Integer> singleDigits = new HashMap<>();
    AtomicReference<Integer> result = new AtomicReference<>(0);

    for (int i = 0; i < dice.length; i++) {
      int currentNumber = dice[i];
      if (singleDigits.containsKey(currentNumber)) {
        singleDigits.put(currentNumber, singleDigits.get(currentNumber) + 1);
      } else {
        singleDigits.put(currentNumber, 1);
      }
    }


    singleDigits.forEach((k, v) -> {
      int numberOfOccurences = v;
      if (v >= 3) {
        result.updateAndGet(v1 -> v1 + trippleDigitsMap.get(k));
        numberOfOccurences = v - 3;
      }
      if (singleDigitsMap.containsKey(k)) {
        int finalNumberOfOccurences = numberOfOccurences;
        result.updateAndGet(v1 -> v1 + singleDigitsMap.get(k) * finalNumberOfOccurences);
      }
    });


    return result.get();
  }

  public static int greedyOptimal(int[] dice) {
    int n[] = new int[7];
    for (int d : dice) n[d]++;
    return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
  }


}
