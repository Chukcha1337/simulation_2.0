package actions;

import entities.Entity;
import entities.unalive.Tree;
import supportClasses.Coordinate;

public class TreeSpawnAction extends SpawnAction {
    private final static double MAX_TREES_MULTIPLIER = 0.03;


    @Override
    protected Class<? extends Entity> getCurrentEntityClass() {
        return Tree.class;
    }

    @Override
    public double getMaxQuantityMultiplier() {
        return MAX_TREES_MULTIPLIER;
    }

    @Override
    public Entity createNewEntity(Coordinate coordinate) {
        return new Tree(coordinate.getColumn(), coordinate.getRow());
    }
}
