package com.roman.procopenco.codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateEncoder  {
    /**
     * https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/train/java
     * @param word
     * @return
     */

    static String encodeHashMap(String word){
        char[] characters = word.toLowerCase().toCharArray();
        Map charMap = new HashMap<Character, Integer>();
        for (char s: characters){
            if (charMap.containsKey(s)){
                int occurences = (int)charMap.get(s);
                charMap.put(s,occurences + 1);
            }else{
                charMap.put(s,1);
            }
        }

        for (int i = 0; i < characters.length; i++){
            int occurences = (int)charMap.get(characters[i]);
            if (occurences > 1){
                characters[i] = ')';
            }else{
                characters[i] = '(';
            }
        }
        return new String(characters);
    }

    static String encodeLastIndexOf(String word){
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }

    static String encodeStream(String word){
        return word.toLowerCase()
                .chars()
                .mapToObj(i -> String.valueOf((char)i))
                .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
                .collect(Collectors.joining());
    }

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