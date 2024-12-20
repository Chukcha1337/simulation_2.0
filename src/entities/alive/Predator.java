package entities.alive;

import actions.PredatorSpawnAction;
import actions.SpawnAction;
import entities.Creature;
import supportClasses.Coordinate;
import supportClasses.WorldMap;

import java.util.Random;

public class Predator extends Creature {
    private final int attackDamage = 4;

    public Predator() {
        health = 9;
        maxHealth = 9;
        speed = 3;
        levelOfHunger = 2;
        isWishToReproduce = false;
        ateThisTurn = false;
        isAlive = true;
        this.food = Herbivore.class;
    }

    @Override
    protected void reproduce(WorldMap worldMap) {
        SpawnAction producer = new PredatorSpawnAction();
        producer.reproduce(worldMap,this);
    }

    @Override
    protected void eat(WorldMap worldMap, Coordinate coordinate) {
        Random rand = new Random();
        if (rand.nextInt(10) > 4) {
            Herbivore herbivore = (Herbivore) worldMap.get(coordinate);
            herbivore.reduceHealth(attackDamage);
            if (herbivore.getHealth() <= 0) {
                kill(herbivore);
                takeStep(worldMap, coordinate);
                if (levelOfHunger > 3) {
                    levelOfHunger -= 2;
                } else {
                    levelOfHunger = 0;
                }
                ateThisTurn = true;
                if (health <= (maxHealth - 3)) {
                    recoverHealth(3);
                }
            } else stepsLeft--;
        }
        stepsLeft--;

    }
}
