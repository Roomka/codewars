package com.roman.procopenco.codewars;


import java.util.List;

/**
 * https://www.codewars.com/kata/578553c3a1b8d5c40300037c/train/java <br>
 * Given an array of one's and zero's convert the equivalent binary value to an integer. <br>
 * Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1. <br>
 * Testing: [0, 0, 0, 1] ==> 1 <br>
 * Testing: [1, 0, 0, 1] ==> 9 <br>
 */

public class BinaryArrayToNumber {
    /**
     * Imperative Solution, calculates the decimal number based on digit position.
     *
     * @param binary list of one and zero.
     * @return converted value in decimal number system.
     */

    public static int ConvertBinaryArrayToIntLoop(List<Integer> binary) {
        int decimalValue = 0;
        for (int i = 0; i < binary.size(); i++) {
            decimalValue += (binary.get(i) * (int) Math.pow(2, binary.size() - i - 1));
        }
        return decimalValue;
    }

    /**
     * Solution with streams, calculates the decimal number based on digit position.
     *
     * @param binary list of one and zero.
     * @return converted value in decimal number system.
     */

    public static int ConvertBinaryArrayToIntStream(List<Integer> binary) {
        return binary.stream().reduce((x, y) -> x * 2 + y).get();
    }

    /**
     * Imperative Solution, calculates the decimal number using Bitwise Bit shift operators and bitwise or.
     *
     * @param binary list of one and zero.
     * @return converted value in decimal number system.
     */

    public static int ConvertBinaryArrayToIntBitwiseOperator(List<Integer> binary) {
        int number = 0;
        for (int bit : binary)
            number = number << 1 | bit;
        return number;
    }
}
