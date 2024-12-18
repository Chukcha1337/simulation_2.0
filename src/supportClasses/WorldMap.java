package supportClasses;


import entities.Entity;


import java.util.Hashtable;
import java.util.List;
import java.util.Map;


public class WorldMap {
    private final int ROWS;
    private final int COLUMNS;
    private final double MAX_MAP_DISTANCE;
    private final Map<Coordinate, Entity> WORLD_MAP = new Hashtable<>();

    public WorldMap(int rows, int columns) {
        this.ROWS = rows;
        this.COLUMNS = columns;
        this.MAX_MAP_DISTANCE = Math.sqrt((Math.pow(rows, 2) + Math.pow(columns, 2)));;
    }

    public int getRows() {
        return ROWS;
    }

    public int getColumns() {
        return COLUMNS;
    }

    public double getMapMaxDistance() {
        return MAX_MAP_DISTANCE;
    }

    public void put(Coordinate coordinate, Entity entity) {
        WORLD_MAP.put(coordinate,entity);
    };

    public Entity get(Coordinate coordinate) {
        return WORLD_MAP.get(coordinate);
    }
    public Entity remove(Coordinate coordinate) {
        return WORLD_MAP.remove(coordinate);
    }

    public Coordinate getCoordinate(Entity entity) {
        return WORLD_MAP.entrySet().stream().filter(e -> e.getValue().equals(entity)).findFirst().get().getKey();
    };

    public List<Entity> getAll() {
        return WORLD_MAP.values().stream().toList();
    };


    public boolean isEmpty(Coordinate coordinate) {
        return !WORLD_MAP.containsKey(coordinate);
    };
    public boolean isNonValid(Coordinate coordinate) {
        return (coordinate.getRow() < 0 ||
                coordinate.getRow() >= ROWS ||
                coordinate.getColumn() < 0 ||
                coordinate.getColumn() >= COLUMNS);
    };
}

