package entities.alive;

import entities.Creature;
import entities.unalive.Grass;
import supportClasses.WorldMap;

public class Predator extends Creature {
    private int attackDamage = 3;

    public Predator(int x, int y) {
        super(x, y);
        health = 10;
        speed = 2;
        levelOfHunger = 1;
        isWishToReproduce = false;
        this.food = Herbivore.class;
    }

    @Override
    public void makeMove(WorldMap worldMap) {

    }
}
