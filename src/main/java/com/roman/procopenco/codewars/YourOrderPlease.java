package com.roman.procopenco.codewars;

import java.util.*;

/**
 * https://www.codewars.com/kata/your-order-please/train/java <br/> <br/>
 * Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result. <br/> <br/>
 * <p>
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0). <br/> <br/>
 * <p>
 * If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers. <br/> <br/>
 * <p>
 * Examples <br/>
 * "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est" <br/>
 * "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople" <br/>
 * ""  -->  "" <br/>
 */

public class YourOrderPlease {
    /**
     * Rearrange the words passed on the original string so that the words are ordered based on the number contained in the string.
     * Imperative solution 1, the algorithm uses a hashmap to store as key the number and as value the word, and
     * then iterates the number ordered to compose the new string.
     *
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
     * Rearrange the words passed on the original string so that the words are ordered based on the number contained in the string.
     * Imperative solution 2, the algorithm uses a hashmap to store as key the number and as value the word, and
     * then iterates the number ordered to compose the new string.
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

    /**
     * Get the number contained in the string, the algorithm remove all non digit characters and return the remaining number contained in the string.
     * @param s
     * @return
     */

    public static int getNumber(String s) {
        String numberOfWord = s.replaceAll("[^0-9]", "");
        if (numberOfWord.trim().isEmpty()) return 0;
        else return Integer.parseInt(numberOfWord.trim());
    }

    /**
     * Rearrange the words passed on the original string so that the words are ordered based on the number contained in the string.
     * Java streams solution 2, the algorithm uses a hashmap to store as key the number and as value the word, and
     * then iterates the number ordered to compose the new string.
     *
     * @param words
     * @return
     */

    public static String orderStream(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
                .reduce((a, b) -> a + " " + b).get();
    }
}


