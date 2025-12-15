import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCount {
    public static void main(String[] args) {
        List<Map<Character, Integer>> allFrequencies = new ArrayList<>();
        while (true) {
            String input = IO.readln("Word? > ");
            if (input.equals("")) break;

            Map<Character, Integer> letterFrequency = countLetter(input);
            allFrequencies.add(letterFrequency);

            IO.println(countLetter(input));
            IO.println("The most used letters in the word " + input + " is " + findHighestValue(letterFrequency));
        }
        Map<Character, Integer> totalFrequency = mergeFrequencyMap(allFrequencies);
        IO.println(totalFrequency);
        IO.println("The most used letters in all words is " + findHighestValue(totalFrequency));
    }

    public static Map<Character, Integer> countLetter(String word) {
        Map<Character, Integer> letters = new HashMap<>();

        char[] wordLetters = word.toCharArray();

        for (char c : wordLetters)
            letters.put(Character.toLowerCase(c), letters.getOrDefault(c, 0) + 1);

        return letters;
    }

    public static <K> Map<K, Integer> mergeFrequencyMap(List<Map<K, Integer>> maps) {
        Map<K, Integer> totalFrequency = new HashMap<>();

        for (Map<K,Integer> map : maps) {
            for (Map.Entry<K, Integer> entry : map.entrySet()) {
                totalFrequency.put(
                    entry.getKey(), 
                    totalFrequency.getOrDefault(entry.getKey(), 0) + entry.getValue()
                );
            }
        }

        return totalFrequency;
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
