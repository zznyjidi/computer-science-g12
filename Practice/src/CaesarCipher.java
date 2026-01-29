public class CaesarCipher {
    public static String encode(String original, int offset) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            encoded.append(shiftIndex(original.charAt(i), offset));
        }
        return encoded.toString();
    }

    public static String decode(String encoded, int offset) {
        return encode(encoded, -offset);
    }

    public static char shiftIndex(char c, int offset) {
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
        String value = "If he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.";
        String encoded = encode(value, 7);
        IO.println(encoded);
        IO.println(decode(encoded, 7));
    }
}
