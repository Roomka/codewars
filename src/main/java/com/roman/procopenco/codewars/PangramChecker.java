package com.roman.procopenco.codewars;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codewars.com/kata/detect-pangram/train/java <br>
 * A pangram is a sentence that contains every single letter of the alphabet at least once.<br/>
 * For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant). <br/>
 * <br/>
 * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation. <br/>
 */

public class PangramChecker {

    /**
     * Checks if a string is a pangram or not.
     * Iterative solution, the algorithm creates a hashset of letters and check is the size is 26, that is if it contains all letters of alphabet.
     *
     * @param sentence
     * @return
     */

    public boolean check(String sentence) {
        //code
        List<String> letterList = new ArrayList<String>();
        Matcher m = Pattern.compile("([a-z])")
                .matcher(sentence.toLowerCase());
        while (m.find()) {
            letterList.add(m.group());
        }
        Set<String> targetSet = new HashSet<String>(letterList);

        return targetSet.size() == 26;
    }

    /**
     * Checks if a string is a pangram or not.
     * Stream java solution 1, the algorithm filter all alphabetic characters and checks if the distinct values count is 26, that is if it contains all letters of alphabet. .
     *
     * @param sentence
     * @return
     */

    public boolean checkStream1(String sentence) {
        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
    }

    /**
     * Checks if a string is a pangram or not.
     * Stream java solution 2, the algorithm filter all letter characters and checks if the distinct values count is 26, that is if it contains all letters of alphabet. .
     *
     * @param sentence
     * @return
     */

    boolean checkStream2(final String sentence) {
        return sentence.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }

}
