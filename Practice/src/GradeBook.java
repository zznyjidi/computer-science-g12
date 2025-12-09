import java.util.HashMap;
import java.util.Map;

public class GradeBook {
    public static void main(String[] args) {
        boolean running = true;
        Map<String, Integer> grades = new HashMap<>();
        while (running) {
            String command = IO.readln("> ");
            switch (command) {
                case "" -> {continue;}
                case "modify" -> grades.put(IO.readln("Name: "), getInteger("Grade: "));
                case "rm" -> grades.remove(IO.readln("Name: "));
                case "ls" -> IO.println(grades);
                case "exit" -> running = false;
                default -> IO.println("Command \"" + command + "\" does not exist. Available commands: modify, rm, ls, exit");
            }
        }
    }

    public static int getInteger(String prompt) {
        String inputString = IO.readln(prompt);
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            IO.println(e.getMessage() + " is not a integer. ");
            return getInteger(prompt);
        }
    }
}
