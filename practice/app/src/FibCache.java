import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibCache {
    static Map<Integer, BigInteger> fibCache = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            IO.print(fibWithCache(i) + ", ");
        }
    }

    public static BigInteger fib(int index) {
        if (index < 2)
            return new BigInteger(String.valueOf(index));
        return fib(index - 1).add(fib(index - 2));
    }

    public static BigInteger fibWithCache(int index) {
        return fibCache.computeIfAbsent(index, k -> fib(k));
    }
}
