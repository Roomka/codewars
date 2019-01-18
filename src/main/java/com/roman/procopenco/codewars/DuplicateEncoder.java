package com.roman.procopenco.codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/train/java
 * The goal of this exercise is to convert a string to a new string where each character in the new string is '(' if that character appears only once in the original string, or ')' if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.
 * <p>
 * Examples:
 * <p>
 * "din" => "((("
 * <p>
 * "recede" => "()()()"
 * <p>
 * "Success" => ")())())"
 * <p>
 * "(( @" => "))((
 */

public class DuplicateEncoder {

    /**
     * Converts a string to a new string composed of round brackets, substitutes  letters appeared once in the string by (, and ) letters appeared multiple times in the string.
     * The algorithm uses a map to save the number of a characters occurrences, if it appears once it substitues with '(' otherwise with ')'.
     * Imperative solution 1.
     *
     * @param word original word to be substituted.
     * @return substituted word.
     */

    static String encodeHashMap(String word) {
        char[] characters = word.toLowerCase().toCharArray();
        Map charMap = new HashMap<Character, Integer>();

        calculateCharOccurences(characters, charMap);
        substituteCharacters(characters, charMap);

        return new String(characters);
    }

    /**
     * Calculates the number of times a character appears in a string and set the number as value in a hashMap.
     *
     * @param characters
     * @param charMap
     */

    private static void calculateCharOccurences(char[] characters, Map charMap) {
        for (char s : characters) {
            if (charMap.containsKey(s)) {
                int occurences = (int) charMap.get(s);
                charMap.put(s, occurences + 1);
            } else {
                charMap.put(s, 1);
            }
        }
    }

    /**
     * Substitute characters with round brackets based on the number of occurrences in the string.
     *
     * @param originalCharacters
     * @param occurrencesCharMap
     */

    private static void substituteCharacters(char[] originalCharacters, Map occurrencesCharMap) {
        for (int i = 0; i < originalCharacters.length; i++) {
            int occurences = (int) occurrencesCharMap.get(originalCharacters[i]);
            if (occurences > 1) {
                originalCharacters[i] = ')';
            } else {
                originalCharacters[i] = '(';
            }
        }
    }

    /**
     * Converts a string to a new string composed of round brackets, substitutes  letters appeared once in the string by (, and ) letters appeared multiple times in the string.
     * The algorithms checks the first and last position of a letter in the string, if it the same it means that the letter appeared once otherwise multiple times.
     * Stream solution 1.
     *
     * @param word original word to be substituted.
     * @return substituted word.
     */


    static String encodeStream(String word) {
        return word.toLowerCase()
                .chars()
                .mapToObj(i -> String.valueOf((char) i))
                .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
                .collect(Collectors.joining());
    }

    /**
     * Converts a string to a new string composed of round brackets, substitutes  letters appeared once in the string by (, and ) letters appeared multiple times in the string.
     * The algorithms stores the number of occurrences of a word, at first occurrences it replaces with  '(' , at second occurrence it substitutes first occurrence and the second one.
     * All successive occurrences are directly substituted with ')'.
     * Imperative solution 2.
     *
     * @param word original word to be substituted.
     * @return substituted word.
     */

    static String encodeHashpMapOptimized(String word) {
        word = word.toLowerCase();

        Map<Character, Integer> letters = new HashMap<Character, Integer>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Integer index = letters.get(c);

            if (index == null) {
                // First occurrence
                result.append("(");
                letters.put(c, i);
            } else if (index >= 0) {
                // 2nd occurrence, replace first instance, and set entry to -1
                result.replace(index, index + 1, ")");
                result.append(")");
                letters.put(c, -1);
            } else {
                result.append(")");
            }
        }
        return result.toString();
    }


}