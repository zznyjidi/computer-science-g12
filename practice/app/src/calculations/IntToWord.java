package calculations;

import java.util.ArrayList;
import java.util.List;

public class IntToWord {
    static String[] numberWords = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    static String[] lastTwoNumber = {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    static String[] tenthDigit = {
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    static String[] digitMark = { "hundred", "thousand" };

    public static String intToWord(int number) {
        if (number == 0)
            return numberWords[0];

        boolean negative = false;
        if (number < 0)
            negative = true;

        List<String> wordList = new ArrayList<>();

        int remaining = (negative ? -1 : 1) * number;
        int digitCount = String.valueOf(remaining).length();

        for (int i = digitCount - 1; i >= 0; i--) {
            int digitUnit = Math.powExact(10, i);
            int digit = remaining / digitUnit;
            remaining = remaining % digitUnit;

            if (digit == 0) {
                if (i > 0 && remaining > 0 && !wordList.getLast().equals("and"))
                    wordList.add("and");
            } else if (i == 1) {
                if (digit > 1) {
                    wordList.add(tenthDigit[digit - 2]);
                } else {
                    wordList.add(lastTwoNumber[remaining]);
                    break;
                }
            } else {
                wordList.add(numberWords[digit]);
                if (i > 1)
                    wordList.add(digitMark[i - 2]);
            }
        }

        return (negative ? "negative " : "") + String.join(" ", wordList);
    }
}
