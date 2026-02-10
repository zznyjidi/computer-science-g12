package cipher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class PasswordManager {

    static File passwordFile = new File("passwords.txt");
    static SecretKey key;
    static String secretSalt = "JCg5Ug7QgXdd2ZieDXng";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        key = AESEncryption.getKeyWithPassword(IO.readln("Master Password: "), secretSalt);

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
                        addPassword(passwords, input[1], input[2], encryptPassword(input[3]));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        IO.println("Not Enough Input. ");
                        e.printStackTrace();
                    }
                }
                case "get" -> {
                    try {
                        IO.println(decryptPassword(passwords.get(input[1]).get(input[2])));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        IO.println("Not Enough Input. ");
                        e.printStackTrace();
                    }
                }
                case "ls" -> {
                    for (Map.Entry<String, Map<String, String>> websiteEntry : passwords.entrySet()) {
                        IO.println(websiteEntry.getKey() + " {");
                        for (Map.Entry<String, String> passwordEntry : websiteEntry.getValue().entrySet()) {
                            IO.println(String.format("    %s", passwordEntry.getKey()));
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
            IO.println("Password Save not found. Starting Fresh. ");
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

    public static String encryptPassword(String password) {
        try {
            byte[] iv = AESEncryption.generateIV();
            return AESEncryption.base64Encoder.encodeToString(iv)
                    + "-" + AESEncryption.encryptString(password, key, iv);
        } catch (InvalidKeyException | NoSuchAlgorithmException
                | NoSuchPaddingException | InvalidAlgorithmParameterException
                | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
            return "ENCRYPT_FAIL";
        }
    }

    public static String decryptPassword(String encrypted) {
        try {
            String[] values = encrypted.split("-");
            return AESEncryption.decryptString(values[1], key, AESEncryption.base64Decoder.decode(values[0]));
        } catch (InvalidKeyException | NoSuchAlgorithmException
                | NoSuchPaddingException | InvalidAlgorithmParameterException
                | IllegalBlockSizeException | BadPaddingException
                | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return "DECRYPT_FAIL";
        }
    }
}
