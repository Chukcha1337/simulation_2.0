import supportClasses.MapPrinter;
import supportClasses.WorldMap;

public class Starter {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap(10,10);
        MapPrinter mapPrinter = new MapPrinter(worldMap);
        mapPrinter.printMap();
    }
}