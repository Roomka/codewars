package com.roman.procopenco.codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Consider a sequence u where u is defined as follows:
 * <p>
 * The number u(0) = 1 is the first one in u. For each x in u, then y = 2 * x + 1 and z = 3 * x + 1
 * must be in u too. There are no other numbers in u. Example: u = [1, 3, 4, 7, 9, 10, 13, 15, 19,
 * 21, 22, 27, ...]
 * <p>
 * 1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7 gives 15 and 22 and so on...
 * <p>
 * Task: Given parameter n the function dbl_linear (or dblLinear...) returns the element u(n) of the
 * ordered sequence u (ordered with < so there are no duplicates) .
 * <p>
 * Example: dbl_linear(10) should return 22
 * <p>
 * Note: Focus attention on efficiency
 * <p>
 * https://www.codewars.com/kata/5672682212c8ecf83e000050/train/java
 */
public class DoubleLinear {

  public static int dblLinear(int n) {
    Set<Integer> uniqueNumbers = new HashSet<>();
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    int currentIndex = 0;
    int nextElementIndex = 1;

    while (nextElementIndex < n * 3) {
      int y = 2 * numbers.get(currentIndex) + 1;
      if (!uniqueNumbers.contains(y)) {
        uniqueNumbers.add(y);
        numbers.add(y);
        nextElementIndex++;
      }

      int z = 3 * numbers.get(currentIndex) + 1;
      if (!uniqueNumbers.contains(z)) {
        uniqueNumbers.add(z);
        numbers.add(z);
        nextElementIndex++;
      }

      currentIndex++;
    }

    Collections.sort(numbers);
    System.out.println(numbers);

    return numbers.get(n);
  }

  public static int dblLinear2(int n) {
    int foundNumbers = 0;
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    int currentNumber = 2;
    int cycles = 0;
    while (foundNumbers <= n) {
      Float yEquation = ( new Float(currentNumber) - 1) / 2;
      if (isInteger(yEquation) && numbers.contains(yEquation.intValue())) {
        numbers.add(currentNumber);
        foundNumbers++;
      } else {
        Float zEquation = ( new Float(currentNumber) - 1) / 3;
        if (isInteger(zEquation) && numbers.contains(zEquation.intValue())) {
          numbers.add(currentNumber);
          foundNumbers++;
        }
      }
      currentNumber++;
      cycles++;
    }

    System.out.println(numbers);
    System.out.println("Cycles " + cycles);

    return numbers.get(n);

  }

  static boolean isInteger (Float value) {
    return (value == Math.floor(value)) && !Float.isInfinite(value);
  }

  public static int dblLinear3 (int n) {
    if (n == 0) return 1;

    SortedSet<Integer> set = new TreeSet<>();
    set.add(1);

    for(int i=0;i<n;i++) {
      int x = set.first();

      set.add(2*x + 1);
      set.add(3*x + 1);
      set.remove(x);
    }

    return set.first();
  }

}
