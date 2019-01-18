package com.roman.procopenco.codewars;


import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.join;
import static java.util.Collections.nCopies;

public class Diamond {

    /**
     * https://www.codewars.com/kata/give-me-a-diamond/train/java
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

    public static String printStream(int n) {
        return n < 0 || n % 2 == 0 ? null : IntStream
                .range(0, n)
                .mapToObj(x ->
                        join("", nCopies(Math.abs(n / 2 - x), " ")) +
                                join("", nCopies(n - 2 * Math.abs(n / 2 - x), "*")))
                .collect(Collectors.joining("\n")) + "\n";
    }
}
