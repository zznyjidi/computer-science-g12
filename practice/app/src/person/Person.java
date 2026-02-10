package person;

public class Person {
    final static int AGE_OF_MAJORITY = 18;

    String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person birthday() {
        age++;
        if (age >= AGE_OF_MAJORITY)
            return ((Child) this).asAdult();
        return this;
    }

    public int getAge() {
        return age;
    }
}
