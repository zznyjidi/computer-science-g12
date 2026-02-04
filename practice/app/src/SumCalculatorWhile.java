public class SumCalculatorWhile {
    public static void main(String[] args) {
        int maxNumber = SumCalculator.getPositiveNumber("Enter a Number > ");
        int sum = 0;
        int currentNumber = 1;
        while (currentNumber < maxNumber) {
            sum += currentNumber;
            currentNumber++;
        }
        IO.println(sum);
    }
}
