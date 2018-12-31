package com.roman.procopenco.codewars;

import java.util.Arrays;

public class HighAndLow {
    /**
     * https://www.codewars.com/kata/554b4ac871d6813a03000035/train/java
     * @param numbers
     * @return
     */
    public static String HighAndLow(String numbers) {
        int[] numbersArray = Arrays.asList(numbers.split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        int min = numbersArray[0];
        int max = numbersArray[0];
        for (int number : numbersArray){
            if (number > max){
                max = number;
            }
            if (number < min ){
                min = number;
            }
        }

        return String.valueOf(max) + " " + String.valueOf(min);
    }
}
