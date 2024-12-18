package supportClasses;

import entities.Creature;
import entities.Entity;

import java.util.HashSet;
import java.util.Set;

public class TargetSetter {
    private final WorldMap worldMap;
    private final Creature creature;
    private final Set<Coordinate> AllTargets;

    public TargetSetter(WorldMap worldMap, Creature creature) {
        this.worldMap = worldMap;
        this.creature = creature;
        AllTargets = new HashSet<>();
        locateAllTargets();
    }

    public void removeTagret (Coordinate target) {
        AllTargets.remove(target);
    }

    private void locateAllTargets() {
        Class<?> target = chooseOfTarget();
        for (Entity entity : worldMap.getAll()) {
            if (entity.getClass().equals(target)) {
                AllTargets.add(worldMap.getCoordinate(entity));
            }
        }
    }

    public Coordinate setTarget(Coordinate creatureCurrentCoordinate) {
        double ShortestDistance = worldMap.getMapMaxDistance();
       Coordinate targetCoordinate = creatureCurrentCoordinate;
        for (Coordinate coordinate : AllTargets) {
            double distanceToCurrentTarget = getShortestPathDistance(creatureCurrentCoordinate, coordinate);
            if (distanceToCurrentTarget < ShortestDistance) {
                ShortestDistance = distanceToCurrentTarget;
                targetCoordinate = coordinate;
            }
        }
        return targetCoordinate;
    }

    public double getShortestPathDistance(Coordinate firstCoordinate, Coordinate secondCoordinate) {
        return Math.sqrt((Math.pow(firstCoordinate.getColumn() - secondCoordinate.getColumn(), 2) + Math.pow(firstCoordinate.getRow() - secondCoordinate.getRow(), 2)));
    }

    private Class<?> chooseOfTarget() {
        if (creature.isWishToReproduce()) {
            return creature.getClass();
        }
        return creature.getFood();
    }

}
