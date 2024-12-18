package actions;

import entities.Entity;
import entities.unalive.Grass;
import supportClasses.Coordinate;

public class GrassSpawnAction extends SpawnAction {
    private final static double MAX_GRASS_MULTIPLIER = 0.06;

    @Override
    public double getMaxQuantityMultiplier() {
        return MAX_GRASS_MULTIPLIER;
    }

    @Override
    public Entity createNewEntity(Coordinate coordinate) {
        return new Grass(coordinate.getColumn(), coordinate.getRow());
    }
}
