package com.roman.procopenco.codewars;

import java.util.*;

public class YourOrderPlease {
    /**
     * https://www.codewars.com/kata/your-order-please/train/java
     * Imperative solution 1
     * @param words
     * @return
     */


    public static String orderImperative1(String words) {
        StringBuilder currentWord = new StringBuilder();
        Map numberMap = new HashMap<Integer, String>();
        int currentWordNumber = -1;
        List<Integer> numberList = new ArrayList(10);
        char[] characters = words.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            char c = characters[i];
            // new word add the item to the map, and clear the string builder
            if (c != ' ') {
                currentWord.append(c);
            }

            if (Character.isDigit(c)) {
                currentWordNumber = Character.getNumericValue(c);
            }
            if (c == ' ' || i == characters.length - 1) {
                numberMap.put(currentWordNumber, currentWord.toString());
                currentWord = new StringBuilder();
                numberList.add(currentWordNumber);
            }


        }
        StringBuilder finalString = new StringBuilder();
        Collections.sort(numberList);

        for (int number : numberList) {
            String currentString = (String) numberMap.get(number);
            finalString.append(currentString).append(' ');
        }

        return finalString.toString().trim();


    }

    /**
     *
     * @param words
     * @return
     */

    public static String orderImperative2(String words) {
        String[] singleWords = words.split(" ");
        HashMap<Integer, String> orderedWords = new HashMap<Integer, String>();
        String resultString = "";

        if (!words.equals("")) {
            for (String singleWord : singleWords) {
                orderedWords.put(getNumber(singleWord), singleWord);
            }

            for (int i = 1; i <= orderedWords.size(); i++) {
                resultString += orderedWords.get(i) + " ";
            }
        }
        return resultString.trim();
    }

    public static int getNumber(String s) {
        String numberOfWord = s.replaceAll("[^0-9]", "");
        return Integer.parseInt(numberOfWord.trim());
    }

    public static String orderStream(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
                .reduce((a, b) -> a + " " + b).get();
    }
}


