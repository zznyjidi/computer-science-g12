public class OOP101 {
    static String something1 = "sth1";

    static {
        IO.println("Hi");
    }

    public static void main(String[] args) {
        String something2 = "sth2";
        printVars(something2);
    }

    static void printVars(String something2) {
        IO.println(something1);
        IO.println(something2);
    }
}
