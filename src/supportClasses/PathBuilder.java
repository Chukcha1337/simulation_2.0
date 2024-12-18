package supportClasses;
import entities.Creature;
import java.util.*;


public class PathBuilder {
    private final TargetSetter targetSetter;
    private final WorldMap worldMap;
    private final Creature creature;
    private final Set<Coordinate> reachableLocations = new HashSet<>();
    private final List<Coordinate> exploredLocations = new LinkedList<>();

    public PathBuilder(WorldMap worldMap, Creature creature) {
        this.worldMap = worldMap;
        this.creature = creature;
        targetSetter = new TargetSetter(worldMap, creature);
    }

    private Set<Coordinate> getNearestLocations(Coordinate coordinate) {
        Set<Coordinate> nearestLocations = new HashSet<>();
        nearestLocations.add(new Coordinate(coordinate.getRow() + 1, coordinate.getColumn() + 1));
        nearestLocations.add(new Coordinate(coordinate.getRow() + 1, coordinate.getColumn() - 1));
        nearestLocations.add(new Coordinate(coordinate.getRow() - 1, coordinate.getColumn() + 1));
        nearestLocations.add(new Coordinate(coordinate.getRow() - 1, coordinate.getColumn() - 1));
        return nearestLocations;
    }

    public List<Coordinate> getPath() {
        List<Coordinate> path = new LinkedList<>();
        while (true) {
            Coordinate start = worldMap.getCoordinate(creature);
            Coordinate target = targetSetter.setTarget(start);
            if (target.equals(start)) {
                break;
            }
            reachableLocations.add(start);
            path = createPathToTarget(start, target);
            if (path.isEmpty()) {
                targetSetter.removeTagret(target);
                continue;
            }
            break;
        }
        return path;
    }

    private List<Coordinate> createPathToTarget(Coordinate start, Coordinate target) {
        List<Coordinate> path = new LinkedList<>();
        while (!reachableLocations.isEmpty()) {
            Coordinate coordinateToCheck = getCoordinateToCheck(target);
            if (coordinateToCheck.equals(target)) {
                path = getPathToTarget(start, target);
                break;
            }
            reachableLocations.remove(coordinateToCheck);
            exploredLocations.add(coordinateToCheck);
            for (Coordinate coordinate : getNearestLocations(coordinateToCheck)) {
                if (worldMap.isNonValid(coordinate)) {
                    continue;
                }
                if (coordinate.equals(target) || isCoordinateEmptyAndNew(coordinate)) {
                    reachableLocations.add(coordinate);
                }
            }
        }
        return path;
    }

    private boolean isCoordinateEmptyAndNew(Coordinate coordinate) {
        return worldMap.isEmpty(coordinate) && !exploredLocations.contains(coordinate);
    }

    private boolean isCloseToStep(Coordinate from, Coordinate to) {
        return Math.abs(from.getRow() - to.getRow()) + Math.abs(from.getColumn() - to.getColumn()) == 1;
    }

    private List<Coordinate> getPathToTarget(Coordinate start, Coordinate target) {
        List<Coordinate> path = new LinkedList<>();
        path.add(target);
        while (!exploredLocations.isEmpty()) {
            if (isCloseToStep(path.getLast(), exploredLocations.getLast())) {
                path.add(exploredLocations.getLast());
                exploredLocations.removeLast();
            } else {
                double maxDistance = worldMap.getMapMaxDistance();
                Coordinate next = null;
                for (Coordinate coordinate : getNearestLocations(path.getLast())) {
                    if (exploredLocations.contains(coordinate)) {
                        double distance = targetSetter.getShortestPathDistance(coordinate, start);
                        if (distance < maxDistance) {
                            maxDistance = distance;
                            next = coordinate;
                        }
                    }
                }
                path.add(next);
            }
        }
        return path;
    }

    private Coordinate getCoordinateToCheck(Coordinate target) {
        double maxDistance = worldMap.getMapMaxDistance();
        Coordinate coordinateToCheck = null;
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
        return coordinateToCheck;
    }
}
