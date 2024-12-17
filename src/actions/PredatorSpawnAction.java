package actions;

import entities.Entity;
import entities.alive.Predator;

public class PredatorSpawnAction extends SpawnAction {
    private final static double MAX_PREDATORS_MULTIPLIER = 0.01;
    @Override
    public double getMaxQuantityMultiplier() {
        return MAX_PREDATORS_MULTIPLIER;
    }

    @Override
    public Entity createNewEntity() {
        return new Predator();
    }
}
