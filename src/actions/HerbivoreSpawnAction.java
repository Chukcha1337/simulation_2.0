package actions;

import entities.Entity;
import entities.alive.Herbivore;
import entities.alive.Predator;
import supportClasses.Coordinate;

public class HerbivoreSpawnAction extends SpawnAction {
    private final static double MAX_HERBIVORES_MULTIPLIER = 0.020;

    @Override
    protected Class<? extends Entity> getCurrentEntityClass() {
        return Herbivore.class;
    }

    @Override
    public double getMaxQuantityMultiplier() {
        return MAX_HERBIVORES_MULTIPLIER;
    }

    @Override
    public Entity createNewEntity(Coordinate coordinate) {
        return new Herbivore();
    }
}


