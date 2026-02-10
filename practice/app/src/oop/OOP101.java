package oop;

public class OOP101 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        IO.println(dog);
        IO.println(dog.getLegs());
        dog.cutALeg();
        IO.println(dog.getLegs());
        dog.bark();
        dog.cutAllLegs();
        IO.println(dog.getLegs());
    }
}
