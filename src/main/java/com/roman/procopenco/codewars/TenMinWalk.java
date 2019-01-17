package com.roman.procopenco.codewars;

import java.util.HashMap;
import java.util.Map;

public class TenMinWalk {
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

    public static boolean isValidStream(char[] walk) {
        String s = new String(walk);
        return s.chars().filter(p->p=='n').count()==s.chars().filter(p->p=='s').count()&&
                s.chars().filter(p->p=='e').count()==s.chars().filter(p->p=='w').count()&&s.chars().count()==10;
    }
}
