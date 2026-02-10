package oop;

import java.awt.Point;

import javax.swing.Icon;

abstract public class GridObject {
    Point position;
    Icon icon;

    public GridObject(Point position, Icon icon) {
        this.position = position;
        this.icon = icon;
    }
}

abstract class Animate extends GridObject {
    double hp;
    double attack;
    double defense;

    public Animate(Point position, Icon icon, double hp, double attack, double defense) {
        super(position, icon);
        this.hp = hp;
        this.attack = attack;
    }

    public double attackOther(Animate other) {
        double damage = attack - other.defense;
        other.hp -= damage > 0 ? damage : 0;
        return damage;
    }
}

class Player extends Animate {

    public Player(Point position, Icon icon, double hp, double attack, double defense) {
        super(position, icon, hp, attack, defense);
    }
}

class Enemy extends Animate {

    public Enemy(Point position, Icon icon, double hp, double attack, double defense) {
        super(position, icon, hp, attack, defense);
    }
}

abstract class Item extends GridObject {

    public Item(Point position, Icon icon) {
        super(position, icon);
    }
}

abstract class PairedItem extends Item {
    int pairID;

    public PairedItem(Point position, Icon icon, int pairID) {
        super(position, icon);
        this.pairID = pairID;
    }

    public int getPairID() {
        return this.pairID;
    }

    public boolean isSamePair(PairedItem other) {
        return this.pairID == other.pairID;
    }
}

class Key extends PairedItem {

    public Key(Point position, Icon icon, int pairID) {
        super(position, icon, pairID);
    }
}

class Door extends PairedItem {

    public Door(Point position, Icon icon, int pairID) {
        super(position, icon, pairID);
    }
}
