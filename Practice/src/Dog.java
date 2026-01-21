public class Dog {
    int legs = 4;

    public void cutAllLegs() {
        cutALeg(legs);
    }

    public void cutALeg() {
        cutALeg(1);
    }

    public void cutALeg(int count) {
        legs -= count;
    }

    public void bark() {
        IO.println("Dooooooooooooooooggggggggggggggggg!");
    }
}
