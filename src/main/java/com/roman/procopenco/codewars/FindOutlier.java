package com.roman.procopenco.codewars;


public class FindOutlier  {

    /**
     * https://www.codewars.com/kata/find-the-parity-outlier/train/java
     * @param integers
     * @return
     */

    static int find(int[] integers){
        int standardNumberModulus = getNumbersModulus(integers);
        boolean found = false;

        for (int i = 0; i < integers.length && !found; i++){
            if (Math.floorMod(integers[i], 2) != standardNumberModulus){
                return integers[i];
            }
        }

        return 0;
    }

    public static int getNumbersModulus(int[] integers){
        if(( Math.floorMod(integers[0], 2) == 0 && Math.floorMod(integers[1],2) == 0) || ( Math.floorMod(integers[1], 2) == 0 && Math.floorMod(integers[2], 2) == 0))
            return 0;
        else
            return 1;
    }
}