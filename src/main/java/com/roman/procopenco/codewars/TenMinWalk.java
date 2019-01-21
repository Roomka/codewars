package com.roman.procopenco.codewars;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/take-a-ten-minute-walk/java <br/>
 *
 * You live in the city of Cartesia where all roads are laid out in a perfect grid. <br/>
 * You arrived ten minutes too early to an appointment, so you decided to take the opportunity to go for a short walk. <br/>
 * The city provides its citizens with a Walk Generating App on their phones -- everytime you press the button it sends you an array of one-letter strings representing directions to walk (eg. ['n', 's', 'w', 'e']).<br/>
 * You always walk only a single block in a direction and you know it takes you one minute to traverse one city block, so create a function that will return true if the walk <br/>
 * the app gives you will take you exactly ten minutes (you don't want to be early or late!) and will, of course, return you to your starting point. Return false otherwise.<br/>
 * <br/>
 * Note: you will always receive a valid array containing a random assortment of direction letters ('n', 's', 'e', or 'w' only). <br/>
 * It will never give you an empty array (that's not a walk, that's standing still!).<br/>
 *
 */

public class TenMinWalk {
    /**
     * Check if list of walks to be done is valid and can be done in 10 minutes or not.
     * Iterative solution.
     * The algorithm uses a HashMap to store the number of times each side of walk is made and checks if the number of times happens on East-West is the same
     * and North-South is the same.
     * @param walk
     * @return
     */

    public static boolean isValid(char[] walk) {
        if (walk.length != 10) return false;

        Map <Character, Integer> directionsTaken = new HashMap<>();
        directionsTaken.put('n',0);
        directionsTaken.put('s',0);
        directionsTaken.put('w',0);
        directionsTaken.put('e',0);

        for (char s : walk){
            directionsTaken.put(s, directionsTaken.get(s) + 1);
        }
        return directionsTaken.get('s') == directionsTaken.get('n') && directionsTaken.get('w') == directionsTaken.get('e');
    }
    /**
     * Check if list of walks to be done is valid and can be done in 10 minutes or not.
     * Solutions using streams.
     * The algorithm checks if the number of times happens on East-West is the same
     * and North-South is the same.
     * @param walk
     * @return
     */


    public static boolean isValidStream(char[] walk) {
        String s = new String(walk);
        return s.chars().filter(p->p=='n').count()==s.chars().filter(p->p=='s').count()&&
                s.chars().filter(p->p=='e').count()==s.chars().filter(p->p=='w').count()&&s.chars().count()==10;
    }
}
