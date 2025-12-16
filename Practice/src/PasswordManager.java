import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordManager {

    static File passwordFile = new File("passwords.txt");

    public static void main(String[] args) {
        Map<String, Map<String, String>> passwords = new HashMap<>();
        loadPasswords(passwords, passwordFile);

        boolean running = true;
        while (running) {
            String[] input = IO.readln("> ").split(" ");
            String command = input[0];
            switch (command) {
                case "exit" -> running = false;
                case "add" -> {
                    try {
                        addPassword(passwords, input[1], input[2], input[3]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        IO.println("Not Enough Input. ");
                        e.printStackTrace();
                    }
                }
                case "ls" -> {
                    for (Map.Entry<String, Map<String, String>> websiteEntry : passwords.entrySet()) {
                        IO.println(websiteEntry.getKey() + " {");
                        for (Map.Entry<String, String> passwordEntry : websiteEntry.getValue().entrySet()) {
                            IO.println(String.format("    %-30s %s", passwordEntry.getKey(), passwordEntry.getValue()));
                        }
                        IO.println("}");
                    }
                }
            }
        }
        savePasswords(passwords, passwordFile);
    }

    public static void loadPasswords(Map<String, Map<String, String>> passwords, File passwordFile) {
        try (Scanner file = new Scanner(passwordFile)) {
            file.useDelimiter(":|\n");
            while (file.hasNext()) {
                addPassword(passwords, file.next(), file.next(), file.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void savePasswords(Map<String, Map<String, String>> passwords, File passwordFile) {
        try {
            if (!passwordFile.exists())
                passwordFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter file = new BufferedWriter(new FileWriter(passwordFile))) {
            for (Map.Entry<String, Map<String, String>> websiteEntry : passwords.entrySet()) {
                for (Map.Entry<String, String> passwordEntry : websiteEntry.getValue().entrySet()) {
                    file.write(websiteEntry.getKey() + ":"
                            + passwordEntry.getKey() + ":"
                            + passwordEntry.getValue() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addPassword(Map<String, Map<String, String>> passwords,
            String website, String username, String password) {
        if (!passwords.containsKey(website))
            passwords.put(website, new HashMap<>());
        passwords.get(website).put(username, password);
    }
}
