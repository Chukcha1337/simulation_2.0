package entities.alive;
import entities.Creature;
import entities.unalive.Grass;

public class Herbivore extends Creature {

    public Herbivore() {
        health = 4;
        speed = 3;
        levelOfHunger = 1;
        isWishToReproduce = false;
        this.food = Grass.class;
    }

    @Override
    protected void makeMove() {
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






}
