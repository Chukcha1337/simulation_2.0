package supportClasses;

import actions.Action;
import actions.RockSpawnAction;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final WorldMap worldMap;
    private final MapPrinter mapPrinter;
    private final List<Action> initActions;
    private final List<Action> turnActions;

    public Simulation(WorldMap worldMap, MapPrinter mapPrinter) {
        this.worldMap = worldMap;
        this.mapPrinter = mapPrinter;
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();
    }

    public void nextTurn() {


    }

    public void startSimulation() {

    }

    public void pauseSimulation() {

    }

}
