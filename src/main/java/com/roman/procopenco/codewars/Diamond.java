package com.roman.procopenco.codewars;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.join;
import static java.util.Collections.nCopies;


/**
 * https://www.codewars.com/kata/give-me-a-diamond/train/java <br/>
 * This kata is to practice simple string output. Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James. Since James doesn't know how to make this happen, he needs your help.<br/>
 * <p>
 * ###Task: <br/>
 * <p>
 * You need to return a string that displays a diamond shape on the screen using asterisk ("*") characters. Please see provided test cases for exact output format.<br/>
 * <p>
 * The shape that will be returned from print method resembles a diamond, where the number provided as input represents the number of *’s printed on the middle line. The line above and below will be centered and will have 2 less *’s than the middle line. This reduction by 2 *’s for each line continues until a line with a single * is printed at the top and bottom of the figure.<br/>
 * <p>
 * Return null if input is even number or negative (as it is not possible to print diamond with even number or negative number).<br/>
 */

public class Diamond {
    /**
     * Print a diamond asterisk composed of number of rows passed as parameter.
     * Iterative Solution implementation.
     *
     * @param n
     * @return
     */

    public static String print(int n) {
        if (n < 0 || Math.floorMod(n, 2) == 0) return null;
        StringBuilder sb = new StringBuilder();
        int spaces = n / 2;
        int asterisks = 1;
        for (int i = 1; i <= n; i++) {
            sb.append(join("", nCopies(spaces, " ")));
            sb.append(join("", nCopies(asterisks, "*")));
            sb.append("\n");
            if (i <= n / 2) {
                spaces = spaces - 1;
                asterisks = asterisks + 2;
            } else {
                spaces = spaces + 1;
                asterisks = asterisks - 2;
            }
        }

        return sb.toString();
    }

    /**
     * Print a diamond asterisk composed of number of rows passed as parameter.
     * Implementation proposed using java streams.
     *
     * @param n
     * @return
     */

    public static String printStream(int n) {
        return n < 0 || n % 2 == 0 ? null : IntStream
                .range(0, n)
                .mapToObj(x ->
                        join("", nCopies(Math.abs(n / 2 - x), " ")) +
                                join("", nCopies(n - 2 * Math.abs(n / 2 - x), "*")))
                .collect(Collectors.joining("\n")) + "\n";
    }
}
