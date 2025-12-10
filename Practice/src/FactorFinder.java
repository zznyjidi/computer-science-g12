import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FactorFinder {
    public static void main(String[] args) {
        int number = SumCalculator.getPositiveNumber("> ");
        Object[] factors = calculateFactor(number).toArray();
        Arrays.sort(factors);
        IO.println(Arrays.toString(factors));
    }

    public static Set<Integer> calculateFactor(int number) {
        Set<Integer> factors = new HashSet<>();

        factors.add(1);
        factors.add(number);

        int bound = (int)Math.sqrt(number);

        for (int i = 2; i <= bound; i++) {
            if (number % i == 0) {
                factors.add(i);
                factors.add(number/i);
            }
        }

        return factors;
    }
}
