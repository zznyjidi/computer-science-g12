package tests;

import java.util.HashMap;
import java.util.Map;

public class JohnFailedATest {
    static String TheGuyFailedTheTest = "John";

    public static void main(String[] args) {
        Map<String, Integer> grades = new HashMap<>();

        grades.put("John", 100);
        grades.put("Jeff", 57);
        grades.put("Jim", 13);

        IO.println(grades);

        grades.put(TheGuyFailedTheTest, 60);

        IO.print(grades.get(TheGuyFailedTheTest));
    }
}
