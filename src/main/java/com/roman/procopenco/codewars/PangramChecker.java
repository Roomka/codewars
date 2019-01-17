package com.roman.procopenco.codewars;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PangramChecker {
    /**
     * https://www.codewars.com/kata/detect-pangram/train/java
     * @param sentence
     * @return
     */



    public boolean check(String sentence){
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

    public boolean checkStream1(String sentence){
        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
    }

    boolean checkStream2(final String sentence) {
        return sentence.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }

}
