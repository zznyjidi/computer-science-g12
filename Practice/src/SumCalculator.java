public class SumCalculator {
    public static void main(String[] args) {
        int maxNumber = getPositiveNumber("Enter a Number > ");
        int sum = 0;
        for (int i = 0; i < maxNumber; i++) {
            sum += i;
        }
        IO.println(sum);
    }
    public static int getNumber(String prompt) {
        try {
            int number = Integer.parseInt(IO.readln(prompt));
            return number;
        }
        catch (NumberFormatException e) {
            IO.println(e.getMessage() + " is not a integer. ");
            return getNumber(prompt);
        }
    }
    public static int getPositiveNumber(String prompt) {
        int number = getNumber(prompt);
        if (number <= 0) {
            IO.println("Enter a positive number! ");
            number = getPositiveNumber(prompt);
        }
        return number;
    }
}
