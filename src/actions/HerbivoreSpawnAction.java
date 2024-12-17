package actions;

import entities.Entity;
import entities.alive.Herbivore;

public class HerbivoreSpawnAction extends SpawnAction {


    @Override
    public Entity createNewEntity() {
        return new Herbivore();
    }

    @Override
    public void execute() {

    }
}


