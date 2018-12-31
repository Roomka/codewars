package com.roman.procopenco.codewars;

public class FindOutlier  {

    /**
     * https://www.codewars.com/kata/find-the-parity-outlier/train/java
     * @param integers
     * @return
     */

    static int find(int[] integers){
        boolean isEven = isEven(integers);

        for (int number : integers){

        }

        return 0;
    }

    public static boolean isEven(int[] integers){
        return (integers[0] % 2 == 0 && integers[1] % 2 == 0) || (integers[1] % 2 == 0 && integers[2] % 2 == 0)
    }
}