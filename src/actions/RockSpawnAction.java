package actions;

import entities.Entity;
import entities.unalive.Rock;
import supportClasses.Coordinate;
import supportClasses.WorldMap;

public class RockSpawnAction extends SpawnAction {
    private final static double MAX_ROCKS_MULTIPLIER = 0.03;

    @Override
    public double getMaxQuantityMultiplier() {
        return MAX_ROCKS_MULTIPLIER;
    }

    @Override
    public Entity createNewEntity(Coordinate coordinate) {
        return new Rock(coordinate.getColumn(), coordinate.getRow());
    }


}
