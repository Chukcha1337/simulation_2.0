package actions;

import entities.Entity;
import entities.alive.Herbivore;
import supportClasses.Coordinate;

public class HerbivoreSpawnAction extends SpawnAction {
    private final static double MAX_HERBIVORES_MULTIPLIER = 0.05;

    @Override
    public double getMaxQuantityMultiplier() {
        return MAX_HERBIVORES_MULTIPLIER;
    }

    @Override
    public Entity createNewEntity(Coordinate coordinate) {
        return new Herbivore(coordinate.getColumn(), coordinate.getRow());
    }
}


