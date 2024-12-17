package supportClasses;

import entities.Entity;
import entities.alive.Herbivore;
import entities.alive.Predator;
import entities.unalive.Grass;
import entities.unalive.Rock;
import entities.unalive.Tree;

public class MapPrinter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private final WorldMap worldMap;

    public MapPrinter(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void printMap() {
        for (int rows = 0; rows < worldMap.getRows(); rows++) {
            StringBuilder line = new StringBuilder();
            for (int columns = 0; columns < worldMap.getColumns(); columns++) {
                Coordinate coordinate = new Coordinate(columns, rows);
                if (worldMap.isEmpty(coordinate)) {
                    line.append(getSpriteForEmptyPlace());
                } else {
                    Entity entity = worldMap.get(coordinate);
                    line.append(getEntitySprite(entity));
                }
            }
            System.out.println(line);
        }
    }

    private String getEntitySprite(Entity entity) {
        if (entity instanceof Herbivore) {
            return ANSI_GREEN_BACKGROUND + Sprites.HERBIVORE.getSprite() + ANSI_RESET;
        }
        if (entity instanceof Predator) {
            return ANSI_GREEN_BACKGROUND + Sprites.PREDATOR.getSprite() + ANSI_RESET;
        }
        if (entity instanceof Rock) {
            return ANSI_GREEN_BACKGROUND + Sprites.ROCK.getSprite() + ANSI_RESET;
        }
        if (entity instanceof Tree) {
            return ANSI_GREEN_BACKGROUND + Sprites.TREE.getSprite() + ANSI_RESET;
        }
        if (entity instanceof Grass) {
            return ANSI_GREEN_BACKGROUND + Sprites.GRASS.getSprite() + ANSI_RESET;
        }
        return " ? ";
    }

    public String getSpriteForEmptyPlace() {
        return (ANSI_GREEN_BACKGROUND + Sprites.EMPTY_PLACE.getSprite() + ANSI_RESET);
    }
}
