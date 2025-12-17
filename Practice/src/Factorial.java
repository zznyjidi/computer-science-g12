public class Factorial {
    public static void main(String[] args) {
        int number = SumCalculator.getPositiveNumber("> ");
        IO.println(factorial(number));
        IO.println(factorialRecursion(number));
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
}
