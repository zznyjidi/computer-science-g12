import java.util.HashSet;
import java.util.Set;

public class VowelCalculator {
    static Set<Character> vowels = new HashSet<>();
    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public static void main(String[] args) {
        while (true) {
            IO.println(countVowel(IO.readln("> ")));
        }
    }

    public static int countVowel(String word) {
        if (word.length() == 0)
            return 0;
        return countVowel(word.substring(1)) + (vowels.contains(word.charAt(0)) ? 1 : 0);
    }
}
