package actions;

import entities.Entity;
import entities.unalive.Rock;
import supportClasses.Coordinate;
import supportClasses.WorldMap;

import java.util.Random;

public abstract class SpawnAction extends Action {
    private Random random = new Random();

    public void spawn(WorldMap worldMap) {
        int counter = 0;
        while (counter < 5) {
            worldMap.put(getRandomEmptyPlace(random, worldMap), createNewEntity());
        }
    }

    public abstract Entity createNewEntity();


    protected Coordinate getRandomEmptyPlace(Random random, WorldMap worldMap) {
        while (true) {
            Coordinate coordinate = new Coordinate(random.nextInt(worldMap.getRows()), random.nextInt(worldMap.getColumns()));
            if (worldMap.isEmpty(coordinate)) {
                return coordinate;
            }
        }
    }
}
