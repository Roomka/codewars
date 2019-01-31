package com.roman.procopenco.codewars;

import java.math.BigInteger;

/**
 * https://www.codewars.com/kata/5541f58a944b85ce6d00006a/train/java <br/><br/>
 * <p>
 * The Fibonacci numbers are the numbers in the following integer sequence (Fn):<br/>
 * <p>
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ... <br/>
 * <p>
 * such as <br/>
 * <p>
 * F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1. <br/>
 * <p>
 * Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying <br/>
 * <p>
 * F(n) * F(n+1) = prod. <br/>
 * <p>
 * Your function productFib takes an integer (prod) and returns an array: <br/>
 * <p>
 * [F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True) <br/>
 * depending on the language if F(n) * F(n+1) = prod. <br/>
 * <p>
 * If you don't find two consecutive F(m) verifying F(m) * F(m+1) = prodyou will return <br/>
 * <p>
 * [F(m), F(m+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False) <br/>
 * F(m) being the smallest one such as F(m) * F(m+1) > prod. <br/>
 * <p>
 * Examples <br/>
 * productFib(714) # should return {21, 34, 1}, <br/>
 * # since F(8) = 21, F(9) = 34 and 714 = 21 * 34 <br/>
 * <p>
 * productFib(800) # should return {34, 55, 0}, <br/>
 * # since F(8) = 21, F(9) = 34, F(10) = 55 and 21 * 34 < 800 < 34 * 55 <br/>
 */

public class ProdFib {
    /**
     * @param prod
     * @return
     */
    public static long[] productFibSolution1(long prod) {
        if (prod == 1) {
            return new long[]{1,1,1};
        }

        long upperBound = (long) ((1 + Math.sqrt(prod)) / 2);

        boolean found = false;
        BigInteger currentValue = new BigInteger(String.valueOf(0));
        BigInteger fib = new BigInteger(String.valueOf(1));
        BigInteger prevFib = new BigInteger(String.valueOf(1));

        int i = 2;

        while (!found && i < upperBound && currentValue.longValue() <= prod) {
            BigInteger temp = fib;
            fib = fib.add(prevFib);
            prevFib = temp;
            currentValue = prevFib.multiply(fib);
            if (currentValue.longValue() == prod) {
                found = true;
            }
            i++;

        }

        if (found) {
            return new long[]{prevFib.longValue(), fib.longValue(), 1};
        } else {
            return new long[]{prevFib.longValue(), fib.longValue(), 0};
        }

    }

    /**
     * Optimized solution.
     * @param prod
     * @return
     */

    public static long[] productFib(long prod) {
        long a = 0L;
        long b = 1L;
        while (a * b < prod) {
            long tmp = a;
            a = b;
            b = tmp + b;
        }
        return new long[]{a, b, a * b == prod ? 1 : 0};
    }

}
