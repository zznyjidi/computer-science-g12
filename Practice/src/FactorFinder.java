import java.util.HashSet;
import java.util.Set;

public class FactorFinder {
    public static void main(String[] args) {
        int number = SumCalculator.getPositiveNumber("> ");
        Set<Integer> factors = calculateFactor(number);
        IO.println(factors);
    }

    public static Set<Integer> calculateFactor(int number) {
        Set<Integer> factors = new HashSet<>();

        factors.add(1);
        factors.add(number);

        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                factors.add(i);
                factors.add(number/i);
            }
        }

        return factors;
    }
}
