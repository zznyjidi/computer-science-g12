import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

    static File textFile = new File("script.txt");

    public static void main(String[] args) {
        try (Scanner file = new Scanner(textFile)) {
            Map<String, Integer> wordFrequency = new HashMap<>();
            while (file.hasNext()) {
                String word = file.next().toLowerCase()
                        .replaceAll("\\.", "")
                        .replaceAll(",", "")
                        .replaceAll(";", "")
                        .replaceAll("\\?", "")
                        .replaceAll("!", "")
                        .strip();
                wordFrequency.compute(word, (key, value) -> (value == null ? 1 : value + 1));
            }

            String word = "";
            do {
                word = IO.readln("Word to Search > ");
                IO.println(wordFrequency.get(word));
            } while (!word.equals(""));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
