
import supportClasses.MapPrinter;
import supportClasses.Simulation;
import supportClasses.WorldMap;

public class Starter {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap(15,15);
        MapPrinter mapPrinter = new MapPrinter(worldMap);
        Simulation simulation = new Simulation(worldMap, mapPrinter);
        simulation.startSimulation();
    }
}