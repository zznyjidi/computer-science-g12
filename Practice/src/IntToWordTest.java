import org.junit.jupiter.api.Test;

public class IntToWordTest {
    @Test
    public void testCoverage() {
        // Zero
        IO.println(IntToWord.intToWord(0));

        // All Digit
        IO.println(IntToWord.intToWord(999));
        IO.println(IntToWord.intToWord(99));

        // 10-19 Edge Case
        IO.println(IntToWord.intToWord(19));
        IO.println(IntToWord.intToWord(10));

        // Whole Numbers
        IO.println(IntToWord.intToWord(100));
        IO.println(IntToWord.intToWord(1000));

        // And
        IO.println(IntToWord.intToWord(101));
        IO.println(IntToWord.intToWord(1001));
        IO.println(IntToWord.intToWord(1010));

        // Negative
        IO.println(IntToWord.intToWord(-25));
    }
}
