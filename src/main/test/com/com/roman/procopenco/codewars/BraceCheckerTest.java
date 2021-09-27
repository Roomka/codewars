package com.roman.procopenco.codewars;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BraceCheckerTest extends  BenchmarkUtility {


    @Benchmark
    @Test
    public void testValid() {
        assertEquals(false, BraceChecker.isValid("((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("));
    }
    @Benchmark
    @Test
    public void testInvalid() {
        assertEquals(false, BraceChecker.isValid("[(])"));
    }

    @Benchmark
    @Test
    public void testValid2_1() {
        assertEquals(false, BraceChecker.isValid2("((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("));
    }

    @Benchmark
    @Test
    public void testInvalid2_2() {
        assertEquals(false, BraceChecker.isValid2("[(])"));
    }

    @Test
    public void isClosingValid() {
        Deque<Character> parentheses = new ArrayDeque<>();
        parentheses.push('(');
        Character validClosingParenthesis = new Character(')');
        Character invalidClosingParenthesis = new Character(']');

        Map<Character, Character> bracesMap = new HashMap<>();
        bracesMap.put('(', ')');
        bracesMap.put('[', ']');
        bracesMap.put('{', '}');

        assertTrue("Return true, the closing bracket is the same as opening.",BraceChecker.isClosingValid(bracesMap, parentheses, validClosingParenthesis));
        assertFalse("Return false, the closing bracket is the different from opening.",BraceChecker.isClosingValid(bracesMap, parentheses, invalidClosingParenthesis));

    }

    @Test
    public void isClosing() {
        Character validOpeningParenthesis = '(';
        Character validClosingParenthesis = ')';

        Character invalidOpeningParenthesis = '(';
        Character invalidClosingParenthesis = ']';

        assertTrue("Return true, the closing bracket is the same as opening.", BraceChecker.isClosing(validOpeningParenthesis, validClosingParenthesis));
        assertFalse("Return false, the closing bracket is different from opening.", BraceChecker.isClosing(invalidOpeningParenthesis, invalidClosingParenthesis));

    }
}