package actions;

import entities.Entity;
import entities.unalive.Tree;

public class TreeSpawnAction extends SpawnAction {
    private final static double MAX_TREES_MULTIPLIER = 0.03;


    @Override
    public double getMaxQuantityMultiplier() {
        return MAX_TREES_MULTIPLIER;
    }

    @Override
    public Entity createNewEntity() {
        return new Tree();
    }
}
