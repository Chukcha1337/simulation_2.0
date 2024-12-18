package entities.alive;
import entities.Creature;
import entities.unalive.Grass;
import supportClasses.Coordinate;
import supportClasses.PathBuilder;
import supportClasses.WorldMap;

import java.util.List;

public class Herbivore extends Creature {

    public Herbivore(int x, int y) {
        super(x, y);
        health = 4;
        speed = 3;
        levelOfHunger = 1;
        isWishToReproduce = false;
        this.food = Grass.class;
    }

    @Override
    public void makeMove(WorldMap worldMap) {
        PathBuilder pathBuilder = new PathBuilder(worldMap, this);
        int stepsLeft = this.getSpeed();
        while (stepsLeft != 0) {
            List<Coordinate> path = pathBuilder.getPath();
            if (path.isEmpty()) {
                break;
            }

//            path.removeLast();
//        if (path.getLast().equals(targetNode)) {
//            eatGrass();
//            takeStep();
//            setGrass(getMaxGrass());
//            continue;
//        }
//        takeStep();
    }

        }


//        getPath();
//        if (!isPathExist) {
//            break;
//        }
//        pathToTarget.removeLast();
//        if (pathToTarget.getLast().equals(targetNode)) {
//            eatGrass();
//            takeStep();
//            setGrass(getMaxGrass());
//            continue;
//        }
//        takeStep();
//    }
    }








