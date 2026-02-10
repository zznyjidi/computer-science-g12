package oop;

public class OOPReview {
    private int int1;
    private int int2;

    public OOPReview(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }

    public String toString() {
        return int1 + " " + int2;
    }

    public void printSomething() {
        IO.println(this);
    }
}

class OOPReviewSubClass extends OOPReview {
    public OOPReviewSubClass(int int1, int int2) {
        super(int1, int2);
    }

    public void printSomething() {
        IO.println("something");
    }
}
