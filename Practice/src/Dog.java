public class Dog {
    protected int legs = 4;

    public void cutAllLegs() {
        cutALeg(legs);
    }

    public void cutALeg() {
        cutALeg(1);
    }

    public void cutALeg(int count) {
        legs -= count;
    }

    public int getLegs() {
        return legs;
    }

    public void bark() {
        IO.println("Dooooooooooooooooggggggggggggggggg!");
    }
}

class Beagle extends Dog {
    public void printLegs() {
        IO.println(this.legs);
    }

    @Override
    public void bark() {
        IO.println("Beagggggggggggggggggggggggggle!");
    }
}

class BlackDog extends Dog {
}

class WhiteDog extends Dog {
}
