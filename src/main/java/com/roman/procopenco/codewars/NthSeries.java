package com.roman.procopenco.codewars;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/555eded1ad94b00403000071/train/java <br/>
 * <p>
 * Task: <br/>
 * Your task is to write a function which returns the sum of following series upto nth term(parameter). <br/>
 * <p>
 * Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +... <br/>
 * Rules: <br/>
 * You need to round the answer to 2 decimal places and return it as String. <br/>
 * <p>
 * If the given value is 0 then it should return 0.00 <br/>
 * <p>
 * You will only be given Natural Numbers as arguments. <br/>
 * <p>
 * Examples: <br/>
 * SeriesSum(1) => 1 = "1.00" <br/>
 * SeriesSum(2) => 1 + 1/4 = "1.25" <br/>
 * SeriesSum(5) => 1 + 1/4 + 1/7 + 1/10 + 1/13 = "1.57" <br/>
 */

public class NthSeries {
    /**
     * Returns the sum of series of number upt to nth therm passed in input.
     * Iterative implementation 1.
     *
     * @param n
     * @return
     */

    public static String seriesSumPersonal(int n) {
        double divideNumber = 1.00;

        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", otherSymbols);
        df.setMaximumFractionDigits(2);
        double result = 0.00;

        for (int i = 1; i <= n; i++) {
            result += (1 / divideNumber);
            divideNumber += 3;
        }

        return df.format(result);
    }

    /**
     * Returns the sum of series of number upt to nth therm passed in input.
     * Iterative implementation 1.
     *
     * @param n
     * @return
     */

    public static String seriesSumImperative(int n) {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", otherSymbols);

        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum += 1.0 / (1 + 3 * i);

        return df.format(sum);
    }

    /**
     * Returns the sum of series of number upt to nth therm passed in input.
     * Implementation using java streams.
     *
     * @param n
     * @return
     */

    public static String seriesSumStream(int n) {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", otherSymbols);

        return df.format(IntStream.range(0, n).mapToDouble(num -> 1.0 / (1 + num * 3)).sum());
    }


}
