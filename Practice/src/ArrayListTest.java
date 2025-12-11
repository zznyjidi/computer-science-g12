import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(1);
        System.out.println(test);
        test.remove((Integer)2);
        System.out.println(test);
    }
}
