public class Fib {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
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
