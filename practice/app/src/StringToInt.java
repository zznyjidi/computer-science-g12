public class StringToInt {
    public static int parseInt(String str) {
        int number = 0;
        boolean negative = false;

        if (str.charAt(0) == '-') {
            negative = true;
        }

        int stringLength = str.length();

        for (int i = negative ? 1 : 0; i < stringLength; i++) {
            int digit = (int) str.charAt(i) - '0';
            if (digit < 0 || digit > 9)
                throw new NumberFormatException(str);
            number += digit * (int) Math.pow(10, stringLength - i - 1);
        }
        return negative ? -number : number;
    }

    public static void main(String[] args) {
        IO.println(parseInt("-876543210"));
    }
}