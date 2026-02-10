package calculations;

public class Factorial {
    public static void main(String[] args) {
        int number = SumCalculator.getPositiveNumber("> ");
        IO.println("Loop: " + factorial(number));
        IO.println("Recursion: " + factorialRecursion(number));
        IO.println("Formula: " + factorialFormula(number));
    }

    public static int factorial(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    public static int factorialRecursion(int number) {
        if (number == 1)
            return 1;
        return factorialRecursion(number - 1) + number;
    }

    public static int factorialFormula(int number) {
        return (1 + number) * number / 2;
    }
}
