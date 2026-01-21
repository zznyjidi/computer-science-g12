public class OOP101 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        IO.println(dog);
        IO.println(dog.legs);
        dog.cutALeg();
        IO.println(dog.legs);
        dog.bark();
        dog.cutAllLegs();
        IO.println(dog.legs);
    }
}
