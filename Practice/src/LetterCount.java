import java.util.HashMap;
import java.util.Map;

public class LetterCount {
    public static void main(String[] args) {
        while (true) {
            String input = IO.readln("Word? > ");
            if (input.equals("")) break;
            IO.println(countLetter(input));
        }
    }

    public static Map<Character, Integer> countLetter(String word) {
        Map<Character, Integer> letters = new HashMap<>();

        char[] wordLetters = word.toCharArray();

        for (char c : wordLetters)
            letters.put(Character.toLowerCase(c), letters.getOrDefault(c, 0) + 1);

        return letters;
    }
}
