package actions;

import entities.Entity;
import supportClasses.Coordinate;
import supportClasses.WorldMap;

import java.util.Random;

public abstract class SpawnAction extends Action {
    private Random random = new Random();

    @Override
    public void execute(WorldMap worldMap) {
        int counter = 0;
        while (counter <= getMaximumQuantity(worldMap)) {
            Coordinate coordinate = getRandomEmptyPlace(random, worldMap);
            worldMap.put(coordinate, createNewEntity(coordinate));
            counter++;
        }
    }

    protected Coordinate getRandomEmptyPlace(Random random, WorldMap worldMap) {
        while (true) {
            Coordinate randomCoordinate = new Coordinate(random.nextInt(worldMap.getRows()), random.nextInt(worldMap.getColumns()));
            if (worldMap.isEmpty(randomCoordinate)) {
                return randomCoordinate;
            }
        }
    }

    public int getMaximumQuantity(WorldMap worldMap) {
        return (int) Math.ceil(worldMap.getRows() * worldMap.getColumns() * getMaxQuantityMultiplier());
    }

    public abstract double getMaxQuantityMultiplier();

    public abstract Entity createNewEntity(Coordinate coordinate);

}
