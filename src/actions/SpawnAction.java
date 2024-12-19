package actions;

import entities.Entity;
import supportClasses.Coordinate;
import supportClasses.WorldMap;

import java.util.Random;

public abstract class SpawnAction extends Action {
    private Random random = new Random();

    @Override
    public void execute(WorldMap worldMap) {
        int counter = (int) worldMap.getAll().stream().filter(a -> a.getClass().equals(getCurrentEntityClass())).count();
        while (counter <= getMaximumQuantity(worldMap)) {
            Coordinate coordinate = getRandomEmptyPlace(random, worldMap);
            worldMap.put(coordinate, createNewEntity(coordinate));
            counter++;
        }
    }
    public void reproduce (WorldMap worldMap, Entity entity) {
        for (Coordinate coordinate : worldMap.getNearestLocations(worldMap.getCoordinate(entity))) {
            if (worldMap.isEmpty(coordinate)) {
                worldMap.put(coordinate, createNewEntity(coordinate));
                break;
            }
        }
    }

    protected abstract Class<? extends Entity> getCurrentEntityClass();

    private Coordinate getRandomEmptyPlace(Random random, WorldMap worldMap) {
        while (true) {
            Coordinate randomCoordinate = new Coordinate(random.nextInt(worldMap.getRows()), random.nextInt(worldMap.getColumns()));
            if (worldMap.isEmpty(randomCoordinate)) {
                return randomCoordinate;
            }
        }
    }

    private int getMaximumQuantity(WorldMap worldMap) {
        return (int) Math.ceil(worldMap.getRows() * worldMap.getColumns() * getMaxQuantityMultiplier());
    }

    protected abstract double getMaxQuantityMultiplier();

    protected abstract Entity createNewEntity(Coordinate coordinate);

}
