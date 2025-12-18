import org.junit.jupiter.api.Test;

public class IntToWordTest {
    @Test
    public void testCoverage() {
        IO.println(IntToWord.intToWord(0));
        IO.println(IntToWord.intToWord(999));
        IO.println(IntToWord.intToWord(99));
        IO.println(IntToWord.intToWord(19));
        IO.println(IntToWord.intToWord(10));
        IO.println(IntToWord.intToWord(100));
        IO.println(IntToWord.intToWord(101));
        IO.println(IntToWord.intToWord(-25));
    }
}
