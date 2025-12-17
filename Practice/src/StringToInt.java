public class StringToInt {
    public static int parseInt(String str) {
        int number = 0;
        boolean negative = false;

        char[] chars = str.toCharArray();
        if (chars[0] == '-') {
            negative = true;
        }

        for (int i = negative ? 1 : 0; i < chars.length; i++) {
            int digit = (int) chars[i] - '0';
            if (digit < 0 || digit > 9)
                throw new NumberFormatException(str);
            number += digit * (int) Math.pow(10, chars.length - i - 1);
        }
        return negative ? -number : number;
    }

    public static void main(String[] args) {
        IO.println(parseInt("-9876543210"));
    }
}