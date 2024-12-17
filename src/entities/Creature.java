package entities;

import entities.unalive.Grass;

public abstract class Creature extends Entity {
    protected int health;
    protected int speed;
    protected int levelOfHunger;
    protected boolean isWishToReproduce;
    protected Class<?> food;

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

    protected abstract void makeMove();
}
