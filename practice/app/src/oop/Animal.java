package oop;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void breath() {
        IO.println("Breathing...");
    }
}

class AnimalDog extends Animal {
    public AnimalDog(String name) {
        super(name);
    }

    public void bark() {
        IO.println("DoGGGGGGGGGGGGGGGGGGGGGGGG!");
    }
}
