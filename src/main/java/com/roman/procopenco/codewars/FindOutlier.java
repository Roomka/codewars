package com.roman.procopenco.codewars;

/**
 * https://www.codewars.com/kata/find-the-parity-outlier/train/java <br/>
 * <p>You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or
 * entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.</p>
 *
 * <p>
 * Examples <br/>
 * [2, 4, 0, 100, 4, 11, 2602, 36] <br/>
 * Should return: 11 (the only odd number) <br/>
 * <p>
 * [160, 3, 1719, 19, 11, 13, -21] <br/>
 * Should return: 160 (the only even number) <br/>
 */

public class FindOutlier {

    /**
     * Returns the outlier number,  that is the number different from all others, supposing that the input array has all numbers odd or even except one.
     * Iterative solution implementation, the algorithm identifies if they array contains most numbers even or odd based on the first three numbers and then iterates
     * through the array to identify the outlier one.
     *
     * @param integers
     * @return outlier number.
     */
    static int find(int[] integers) {
        int standardNumberModulus = getNumbersModulus(integers);
        boolean found = false;

        for (int i = 0; i < integers.length && !found; i++) {
            if (Math.floorMod(integers[i], 2) != standardNumberModulus) {
                return integers[i];
            }
        }

        return 0;
    }

    /**
     * Returns array modulus based on first three items.
     *
     * @param integers
     * @return 0 if they are even numbers, odd otherwise.
     */

    public static int getNumbersModulus(int[] integers) {
        if ((Math.abs(integers[0] % 2) == 0 && Math.abs(integers[1]% 2) == 0) || (Math.abs(integers[1] % 2) == 0 && Math.abs(integers[2] % 2) == 0) || (Math.abs(integers[0] % 2) == 0 && Math.abs(integers[2] % 2) == 0))
            return 0;
        else
            return 1;
    }
}