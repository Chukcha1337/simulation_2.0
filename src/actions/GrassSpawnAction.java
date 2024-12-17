package actions;

import entities.Entity;
import entities.unalive.Grass;

public class GrassSpawnAction extends SpawnAction {
    private final static double MAX_GRASS_MULTIPLIER = 0.06;

    @Override
    public double getMaxQuantityMultiplier() {
        return MAX_GRASS_MULTIPLIER;
    }

    @Override
    public Entity createNewEntity() {
        return new Grass();
    }
}
