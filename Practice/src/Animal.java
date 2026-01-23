public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void breath() {
        IO.println("Breathing...");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void bark() {
        IO.println("DoGGGGGGGGGGGGGGGGGGGGGGGG!");
    }
}
