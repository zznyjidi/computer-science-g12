public class CaesarCipher {
    public static String encode(String original, int offset) {
        offset = offset % 26;
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            encoded.append(shiftIndex(original.charAt(i), offset));
        }
        return encoded.toString();
    }

    public static String decode(String encoded, int offset) {
        return encode(encoded, -offset);
    }

    private static char shiftIndex(char c, int offset) {
        if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')))
            return c;
        int newIndex = c + offset;
        if ((c <= 'Z' && newIndex > 'Z') || (c <= 'z' && newIndex > 'z'))
            newIndex -= 26;
        if ((c >= 'A' && newIndex < 'A') || (c >= 'a' && newIndex < 'a'))
            newIndex += 26;
        return (char) newIndex;
    }

    public static void main(String[] args) {
        while (true) {
            String value = IO.readln("> ");
            int offset = Integer.parseInt(IO.readln("Offset: "));

            String encoded = encode(value, offset);
            IO.println(encoded);
            IO.println(decode(encoded, offset));
        }
    }
}
