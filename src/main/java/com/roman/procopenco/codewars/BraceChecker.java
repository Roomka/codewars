package com.roman.procopenco.codewars;

import java.util.*;

public class BraceChecker  {
    /**
     * https://www.codewars.com/kata/5277c8a221e209d3f6000b56/solutions/java
     * @param braces
     * @return
     */

    public static boolean isValid(String braces) {
        Deque<Character> parentheses = new ArrayDeque<>();

        Map<Character, Character>bracesMap = new HashMap<>();
        bracesMap.put('(', ')');
        bracesMap.put('[', ']');
        bracesMap.put('{', '}');


        for (Character c: braces.toCharArray()) {
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                parentheses.push(c);
            }else if (!isClosingValid(bracesMap, parentheses, c)){
                return false;
            }else{
                parentheses.pop();
            }

        }
        return parentheses.isEmpty();

    }

    private static boolean isClosingValid(Map<Character, Character>bracesMap, Deque deque, Character closingCharacter){
        if (deque.isEmpty()){
            return false;
        }

        Character openingCharacter = (Character) deque.peek();
        return bracesMap.get(openingCharacter) != null && bracesMap.get(openingCharacter).equals(closingCharacter);
    }

    public static boolean isValid2(String braces) {
        Stack<Character> s = new Stack<>();
        for (char c : braces.toCharArray())
            if (s.size() > 0 && isClosing(s.peek(), c)) s.pop();
            else s.push(c);
        return s.size() == 0;
    }

    public static boolean isClosing(char x, char c) {
        return (x == '{' && c == '}') || (x == '(' && c == ')') || (x == '[' && c == ']');
    }

}
