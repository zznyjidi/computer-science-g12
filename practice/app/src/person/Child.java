package person;

public class Child extends Person {
    public Child(String name, int age) {
        super(name, age);
    }

    public Adult asAdult() {
        if (getAge() < Person.AGE_OF_MAJORITY)
            throw new IllegalStateException();
        return new Adult(name, getAge());
    }
}
