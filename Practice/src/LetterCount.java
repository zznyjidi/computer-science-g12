import java.util.HashMap;
import java.util.Map;

public class LetterCount {
    public static void main(String[] args) {
        while (true) {
            String input = IO.readln("Word? > ");
            if (input.equals("")) break;

            Map<Character, Integer> letterFrequency = countLetter(input);

            IO.println(countLetter(input));
            IO.println("The most used letters in the word " + input + " is " + findHighestValue(letterFrequency));
        }
    }

    public static Map<Character, Integer> countLetter(String word) {
        Map<Character, Integer> letters = new HashMap<>();

        char[] wordLetters = word.toCharArray();

        for (char c : wordLetters)
            letters.put(Character.toLowerCase(c), letters.getOrDefault(c, 0) + 1);

        return letters;
    }

    public static <K> K findHighestValue(Map<K, Integer> inputMap) {
        int highestValue = Integer.MIN_VALUE;
        K highestKey = null;

        for (Map.Entry<K, Integer> entry : inputMap.entrySet()) {
            if (entry.getValue() > highestValue) {
                highestKey = entry.getKey();
                highestValue = entry.getValue();
            }
        }

        return highestKey;
    }
}
