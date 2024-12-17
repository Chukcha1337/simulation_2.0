package actions;

import entities.Entity;
import entities.unalive.Rock;
import supportClasses.Coordinate;
import supportClasses.WorldMap;

import java.util.Random;

public abstract class SpawnAction extends Action {
    private Random random = new Random();

    @Override
    public void execute(WorldMap worldMap) {
        int counter = 0;
        while (counter <= getMaximumQuantity(worldMap)) {
            worldMap.put(getRandomEmptyPlace(random, worldMap), createNewEntity());
            counter++;
        }
    }

    protected Coordinate getRandomEmptyPlace(Random random, WorldMap worldMap) {
        while (true) {
            Coordinate coordinate = new Coordinate(random.nextInt(worldMap.getRows()), random.nextInt(worldMap.getColumns()));
            if (worldMap.isEmpty(coordinate)) {
                return coordinate;
            }
        }
    }

    public int getMaximumQuantity(WorldMap worldMap) {
        return (int) Math.ceil(worldMap.getRows() * worldMap.getColumns() * getMaxQuantityMultiplier());
    }

    public abstract double getMaxQuantityMultiplier();

    public abstract Entity createNewEntity();

}
