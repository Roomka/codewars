package com.roman.procopenco.codewars;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.stream.IntStream;

public class NthSeries {
    /**
     * https://www.codewars.com/kata/555eded1ad94b00403000071/train/java
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

        for (int i = 1; i <= n; i++){
            result += (1 / divideNumber);
            divideNumber += 3;
        }

        return df.format(result);
    }


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

    public static String seriesSumStream(int n) {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", otherSymbols);

        return df.format(IntStream.range(0, n).mapToDouble(num -> 1.0 / (1 + num * 3)).sum());
    }


}
