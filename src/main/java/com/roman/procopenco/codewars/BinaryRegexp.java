package com.roman.procopenco.codewars;

import java.util.regex.Pattern;

/**
 * https://www.codewars.com/kata/binary-multiple-of-3/train/java <br/><br/>
 *
 * In this kata, your task is to create a regular expression capable of evaluating binary strings (strings with only 1s and 0s) and determining whether the given string represents a number divisible by 3. <br/><br/>
 *
 * Take into account that: <br/><br/>
 *
 * An empty string might be evaluated to true (it's not going to be tested, so you don't need to worry about it - unless you want) <br/>
 * The input should consist only of binary digits - no spaces, other digits, alphanumeric characters, etc.<br/>
 * There might be leading 0s.<br/>
 * Examples (Javascript)<br/>
 * multipleof3Regex.test('000') should be true <br/>
 * multipleof3Regex.test('001') should be false <br/>
 * multipleof3Regex.test('011') should be true <br/>
 * multipleof3Regex.test('110') should be true <br/>
 * multipleof3Regex.test(' abc ') should be false <br/>
 * You can check more in the example test cases <br/><br/>
 *
 * Note<br/>
 * There's a way to develop an automata (FSM) that evaluates if strings representing numbers in a given base are divisible by a given number. You might want to check an example of an automata for doing this same particular task here.<br/><br/>
 *
 * If you want to understand better the inner principles behind it, you might want to study how to get the modulo of an arbitrarily large number taking one digit at a time.
 */

public class BinaryRegexp {

    public static Pattern multipleOf3() {
        // Regular expression that matches binary inputs that are multiple of 3
        return Pattern.compile("");
    }
}
