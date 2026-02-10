package calculations;

public class Fib {
    public static void main(String[] args) {
        int input = SumCalculator.getPositiveNumber("> ");
        for (int i = 0; i <= input; i++) {
            IO.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int index) {
        if (index == 0)
            return 0;
        if (index == 1)
            return 1;
        return fibonacci(index - 1) + fibonacci(index - 2);
    }
}
