package calculations;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LetterCount {
    public static void main(String[] args) {
        Map<Character, Integer> totalFrequencies = new HashMap<>();
        while (true) {
            String input = IO.readln("Word? > ");
            if (input.equals(""))
                break;

            Map<Character, Integer> letterFrequency = countLetter(input);
            mergeFrequencyMap(totalFrequencies, letterFrequency);

            IO.println(countLetter(input));
            IO.println("The most used letters in the word " + input + " is " + findHighestValue(letterFrequency));
        }
        IO.println(totalFrequencies);
        IO.println("The most used letters in all words is " + findHighestValue(totalFrequencies));
    }

    public static Map<Character, Integer> countLetter(String word) {
        Map<Character, Integer> letters = new HashMap<>();

        char[] wordLetters = word.toCharArray();

        for (char c : wordLetters)
            letters.put(Character.toLowerCase(c), letters.getOrDefault(c, 0) + 1);

        return letters;
    }

    public static <K> Map<K, Integer> mergeFrequencyMap(Map<K, Integer> baseMaps, Map<K, Integer> additional) {
        additional.forEach((key, value) -> baseMaps.merge(key, value, (value1, value2) -> (value1 + value2)));
        return baseMaps;
    }

    public static <K> K findHighestValue(Map<K, Integer> inputMap) {
        return Collections.max(inputMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
