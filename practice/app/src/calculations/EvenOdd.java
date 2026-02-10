package calculations;

public class EvenOdd {
    public static void main(String[] args) {
        int input = SumCalculator.getPositiveNumber("Input a Number > ");
        if (input % 2 == 0) {
            IO.println(input + " is a Even Number. ");
        } else {
            IO.println(input + " is a Odd Number. ");
        }
    }
}
