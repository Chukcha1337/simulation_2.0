package entities.alive;
import actions.HerbivoreSpawnAction;
import actions.PredatorSpawnAction;
import actions.SpawnAction;
import entities.Creature;
import entities.unalive.Grass;
import supportClasses.Coordinate;
import supportClasses.MapPrinter;
import supportClasses.PathBuilder;
import supportClasses.WorldMap;

import java.util.List;

public class Herbivore extends Creature {

    public Herbivore(int x, int y) {
        super(x, y);
        health = 4;
        speed = 3;
        stepsLeft = speed;
        levelOfHunger = 2;
        isWishToReproduce = false;
        ateThisTurn = false;
        isAlive = true;
        this.food = Grass.class;
    }

    @Override
    protected void reproduce(WorldMap worldMap) {
        SpawnAction producer = new HerbivoreSpawnAction();
        producer.reproduce(worldMap,this);
    }

    @Override
    protected void eat(WorldMap worldMap, Coordinate coordinate) {
        takeStep(worldMap, coordinate);
        if (levelOfHunger > 2) {
            levelOfHunger -= 2;
        } else {
            levelOfHunger = 0;
        }
        ateThisTurn = true;
        if (health <= (MAX_HEALTH - 1)) {
            recoverHealth(1);
        }
    }



}


