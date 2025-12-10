import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FactorFinder {
    public static void main(String[] args) {
        int number = SumCalculator.getPositiveNumber("> ");
        Set<Integer> factors = calculateFactor(number);
        boolean numberIsPrime = isPrime(factors);

        IO.println(number + (numberIsPrime? " is a prime. " : " is not a prime. "));
        IO.println("Factors: " + toSortedString(factors));

        if (!numberIsPrime) {
            IO.println("Input a positive number to find if it is a factor \nInput a negative number or 0 to exit");
            while (true) {
                int inputNumber = SumCalculator.getNumber("> ");
                if (inputNumber > 0) {
                    IO.println(inputNumber + " is" + (isFactor(factors, inputNumber)?" ":" not ") + "a factor of " + number + ". ");
                } else {
                    break;
                }
            }
        }
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

    public static boolean isPrime(int number) {
        return isPrime(calculateFactor(number));
    }

    public static boolean isPrime(Set<Integer> factors) {
        return factors.size() == 2;
    }

    public static boolean isFactor(int bigNumber, int number) {
        return isFactor(calculateFactor(bigNumber), number);
    }

    public static boolean isFactor(Set<Integer> factors, int number) {
        return factors.contains(number);
    }

    public static <T> String toSortedString(Set<T> set) {
        Object[] array = set.toArray();
        Arrays.sort(array);
        return Arrays.toString(array);
    }
}
