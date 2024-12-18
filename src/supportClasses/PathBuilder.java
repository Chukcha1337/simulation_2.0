package supportClasses;

import entities.Creature;

import java.util.*;


public class PathBuilder {
    private final TargetSetter targetSetter;
    private final WorldMap worldMap;
    private final Creature creature;
    private final Set<Coordinate> nonReachableTargets = new HashSet<>();
    private final Set<Coordinate> reachableLocations = new LinkedHashSet<>();
    private Coordinate coordinateToCheck;
    private Coordinate potentialCoordinateToCheck;
    private final Set<Coordinate> exploredLocations = new LinkedHashSet<>();
    private final Set<Coordinate> reachableFromHere = new LinkedHashSet<>();
    private final List<Coordinate> pathToTarget = new LinkedList<>();

    public PathBuilder(WorldMap worldMap, Creature creature) {
        this.worldMap = worldMap;
        this.creature = creature;
        targetSetter = new TargetSetter(worldMap, creature);
    }

    public Set<Coordinate> getPath() {
        Set<Coordinate> path = new LinkedHashSet<>();
        Coordinate start = worldMap.getCoordinate(creature);
        Coordinate target = targetSetter.setTarget(start, nonReachableTargets);
        if (target == start) {
            // придумать логику
        }
        reachableLocations.add(start);
        createPathToTarget(target);


        return path;
    }

    private void createPathToTarget(Coordinate target) {
        while (!reachableLocations.isEmpty()) {
            getCoordinateToCheck(target);
            if (coordinateToCheck.equals(target)) {
                setPathToTarget(target);
                break;
            }
//            prepareCollectionsToAddition();
            for (int column = -1; column <= 1; column++) {
                for (int row = -1; row <= 1; row++) {
                    if (isCoordinateValid(row, column)) {
                        setPotentialCoordinate(row, column);
                        if (worldMap.isNonValid(potentialCoordinateToCheck)) {
                            continue;
                        }
                        if (potentialCoordinateToCheck.equals(target) || isCoordinateEmptyAndNew()) {
                            reachableFromHere.add(potentialCoordinateToCheck);
                        }

                    }
                }
            }
            setLocations()


        }
    }

    private void setLocations() {
        for (Coordinate coordinate : reachableFromHere) {
            if (!reachableLocations.contains(coordinate)) {
                node.setPrevious(nodeBeingChecked);
                reachableLocations.add(node);
            }
        }
    }

    private boolean isCoordinateEmptyAndNew() {
        return worldMap.isEmpty(potentialCoordinateToCheck) && !exploredLocations.contains(potentialCoordinateToCheck);
    }

    private void setPotentialCoordinate(int row, int column) {
        potentialCoordinateToCheck = new Coordinate(coordinateToCheck.getRow() + row, coordinateToCheck.getColumn() + column);
    }

    private boolean isCoordinateValid(int row, int column) {
        return Math.abs(row) + Math.abs(column) == 1;
    }

    private void setPathToTarget(Coordinate target) {

    }

    private void getCoordinateToCheck(Coordinate target) {
        double maxDistance = worldMap.getMapMaxDistance();
        for (Coordinate coordinate : reachableLocations) {
            if (coordinate.equals(target)) {
                coordinateToCheck = coordinate;
                break;
            }
            double distance = targetSetter.getShortestPathDistance(coordinate, target);
            if (distance < maxDistance) {
                maxDistance = distance;
                coordinateToCheck = coordinate;
            }
        }
    }

}
