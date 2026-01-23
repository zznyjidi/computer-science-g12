public class OOP102 {
    static final Course ICS4U = new Course("ICS4U", "Mr. Smith");

    public static void main(String[] args) {
        Student james = new Student("James", ICS4U);

        IO.println(james.name);
        IO.println(james.course);
        IO.println(james.grade);
    }
}
