package com.roman.procopenco.codewars;

import java.util.*;

/**
 * https://www.codewars.com/kata/valid-braces/java <br>
 * Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid. <br>
 * <p>
 * This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!
 * <p>
 * All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
 * <p>
 * What is considered Valid?
 * A string of braces is considered valid if all braces are matched with the correct brace.
 * <p>
 * Examples
 * "(){}[]"   =>  True
 * "([{}])"   =>  True
 * "(}"       =>  False
 * "[(])"     =>  False
 * "[({})](]" =>  False
 */

public class BraceChecker {
    /**
     * Imperative solution, that uses a stack to add all opening braces and pop al closing ones.
     * The algorithm checks.
     *
     * @param braces string of braces.
     * @return order of braces is valid or not.
     */

    public static boolean isValid(String braces) {
        Deque<Character> parentheses = new ArrayDeque<>();

        Map<Character, Character> bracesMap = new HashMap<>();
        bracesMap.put('(', ')');
        bracesMap.put('[', ']');
        bracesMap.put('{', '}');


        for (Character c : braces.toCharArray()) {
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                parentheses.push(c);
            } else if (!isClosingValid(bracesMap, parentheses, c)) {
                return false;
            } else {
                parentheses.pop();
            }

        }
        return parentheses.isEmpty();
    }

    /**
     * Checks if the closing brace is valid, based on the opening one added to stack.
     *
     * @param bracesMap        map with braces, key as opening brace and value as closing brace.
     * @param deque            stack with braces
     * @param closingCharacter last closing character.
     * @return if closing bracket is valid or not.
     */

    private static boolean isClosingValid(Map<Character, Character> bracesMap, Deque deque, Character closingCharacter) {
        if (deque.isEmpty()) {
            return false;
        }

        Character openingCharacter = (Character) deque.peek();
        return bracesMap.get(openingCharacter) != null && bracesMap.get(openingCharacter).equals(closingCharacter);
    }

    /**
     * Imperative solution, that uses a stack to add all opening braces and pop al closing ones.
     * The algorithm checks.
     *
     * @param braces string of braces.
     * @return order of braces is valid or not.
     */

    public static boolean isValid2(String braces) {
        Stack<Character> s = new Stack<>();
        for (char c : braces.toCharArray())
            if (s.size() > 0 && isClosing(s.peek(), c)) s.pop();
            else s.push(c);
        return s.size() == 0;
    }

    /**
     * Checks if closing bracket is valid , that is if it's the same type as opening one.
     *
     * @param openingBracket
     * @param closingBracket
     * @return if closing bracket is valid or not.
     */

    public static boolean isClosing(char openingBracket, char closingBracket) {
        return (openingBracket == '{' && closingBracket == '}') || (openingBracket == '(' && closingBracket == ')') || (openingBracket == '[' && closingBracket == ']');
    }

}
