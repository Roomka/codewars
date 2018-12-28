package com.roman.procopenco.codewars;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.State;

import java.util.List;

public class BinaryArrayToNumber {
    /**
     * https://www.codewars.com/kata/578553c3a1b8d5c40300037c/train/java
     * @param binary
     * @return
     */

    public static int ConvertBinaryArrayToIntLoop(List<Integer> binary) {
        int decimalValue = 0;
        for (int i = 0; i < binary.size(); i++){
            decimalValue +=  (binary.get(i) * (int) Math.pow(2,binary.size()- i - 1));
        }
        return decimalValue;
    }

    public static int ConvertBinaryArrayToIntStream(List<Integer> binary) {
        return binary.stream().reduce((x, y) -> x * 2 + y).get();
    }


    public static int ConvertBinaryArrayToIntBitwiseOperator(List<Integer> binary) {
        int number = 0;
        for (int bit : binary)
            number = number << 1 | bit;
        return number;
    }
}
