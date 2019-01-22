package com.roman.procopenco.codewars;

/**
 * https://www.codewars.com/kata/5541f58a944b85ce6d00006a/train/java <br/><br/>
 *
 * The Fibonacci numbers are the numbers in the following integer sequence (Fn):<br/>
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ... <br/>
 *
 * such as <br/>
 *
 * F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1. <br/>
 *
 * Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying <br/>
 *
 * F(n) * F(n+1) = prod. <br/>
 *
 * Your function productFib takes an integer (prod) and returns an array: <br/>
 *
 * [F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True) <br/>
 * depending on the language if F(n) * F(n+1) = prod. <br/>
 *
 * If you don't find two consecutive F(m) verifying F(m) * F(m+1) = prodyou will return <br/>
 *
 * [F(m), F(m+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False) <br/>
 * F(m) being the smallest one such as F(m) * F(m+1) > prod. <br/>
 *
 * Examples <br/>
 * productFib(714) # should return {21, 34, 1}, <br/>
 *                 # since F(8) = 21, F(9) = 34 and 714 = 21 * 34 <br/>
 *
 * productFib(800) # should return {34, 55, 0}, <br/>
 *                 # since F(8) = 21, F(9) = 34, F(10) = 55 and 21 * 34 < 800 < 34 * 55 <br/>
 *
 *
 *
 */

public class ProdFib {
    /**
     *
     * @param prod
     * @return
     */
    public static long[] productFib(long prod) {
        // your code
        return null;
    }

}
