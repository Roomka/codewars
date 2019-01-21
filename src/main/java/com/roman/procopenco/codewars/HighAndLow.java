package com.roman.procopenco.codewars;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/554b4ac871d6813a03000035/train/java <br/>
 * <p>
 * In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number. <br/>
 * <p>
 * Example: <br/>
 * <p>
 * HighAndLow("1 2 3 4 5")  // return "5 1" <br/>
 * HighAndLow("1 2 -3 4 5") // return "5 -3" <br/>
 * HighAndLow("1 9 3 4 -5") // return "9 -5" <br/>
 * Notes: <br/>
 * <p>
 * All numbers are valid Int32, no need to validate them. <br/>
 * There will always be at least one number in the input string. <br/>
 * Output string must be two numbers separated by a single space, and highest number is first. <br/>
 */

public class HighAndLow {
    /**
     * Returns the highest and lowest number from a string contains a list of numbers separated by whitespace.
     *
     * @param numbers
     * @return a string containing max value and min value separated by whitespace.
     */
    public static String HighAndLow(String numbers) {
        int[] numbersArray = Arrays.asList(numbers.split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        int min = numbersArray[0];
        int max = numbersArray[0];
        for (int number : numbersArray) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        return String.valueOf(max) + " " + String.valueOf(min);
    }
}
