package supportClasses;

import entities.Entity;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class WorldMap {
    private final int ROWS;
    private final int COLUMNS;
    private final Map<Coordinate, Entity> WORLD_MAP = new Hashtable<>();

    public WorldMap(int rows, int columns) {
        this.ROWS = rows;
        this.COLUMNS = columns;
    }

    public int getRows() {
        return ROWS;
    }

    public int getColumns() {
        return COLUMNS;
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
    public boolean isValid(Coordinate coordinate) {
        return ((coordinate.getRow() < ROWS) && (coordinate.getColumn() < COLUMNS));
    };
}

