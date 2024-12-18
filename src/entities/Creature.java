package entities;

import entities.unalive.Grass;
import supportClasses.WorldMap;

public abstract class Creature extends Entity {
    protected int health;
    protected int speed;
    protected int levelOfHunger;
    protected boolean isWishToReproduce;
    protected Class<?> food;

    public Creature(int x, int y) {
        super(x,y);
    }

    public void reduceHealth(int damage) {
        health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLevelOfHunger() {
        return levelOfHunger;
    }

    public boolean isWishToReproduce() {
        return isWishToReproduce;
    }

    public Class<?> getFood() {
        return food;
    }

    public abstract void makeMove(WorldMap worldMap);
}
