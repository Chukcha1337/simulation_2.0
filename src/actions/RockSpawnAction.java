package actions;

import entities.Entity;
import entities.unalive.Rock;
import supportClasses.Coordinate;
import supportClasses.WorldMap;

import java.util.Random;

public class RockSpawnAction extends SpawnAction {

    @Override
    public Entity createNewEntity() {
        return new Rock();
    }
}
