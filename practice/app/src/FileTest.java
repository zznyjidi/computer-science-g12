import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) {
        File testFile = new File("testFile.txt");

        try (Scanner file = new Scanner(testFile)) {
            IO.println(file.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("testFile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
