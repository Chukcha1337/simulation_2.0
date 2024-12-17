package entities.alive;

import entities.Creature;
import entities.unalive.Grass;

public class Predator extends Creature {
    private int attackDamage = 3;

    public Predator() {
        health = 10;
        speed = 2;
        levelOfHunger = 1;
        isWishToReproduce = false;
        this.food = Herbivore.class;
    }
}
