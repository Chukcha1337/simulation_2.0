package entities;

import supportClasses.Coordinate;
import supportClasses.MapPrinter;
import supportClasses.PathBuilder;
import supportClasses.WorldMap;

import java.util.List;

public abstract class Creature extends Entity {
    protected int health;
    protected int maxHealth;
    protected int speed;
    protected int levelOfHunger;
    protected boolean ateThisTurn;
    protected int stepsLeft;
    protected boolean isWishToReproduce;
    protected boolean isAlive;
    protected Class<?> food;

    public boolean isAlive() {
        return isAlive;
    }

    protected void kill(Creature creature) {
        creature.isAlive = false;
    }

    public String showAim() {
        if(isWishToReproduce) {
            return "s";
        } else {
            return "e";
        }
    }

    public void reduceHealth(int damage) {
        health -= damage;
    }

    protected void recoverHealth(int recover) {
        health += recover;
    }

    public int getHealth() {
        return health;
    }

    private int getSpeed() {
        return speed;
    }

    public boolean isWishToReproduce() {
        return isWishToReproduce;
    }
    private void setWishToReproduce(boolean isWishToReproduce) {
        this.isWishToReproduce = isWishToReproduce;
    }
    public void reverseWishToReproduce() {
        isWishToReproduce = !isWishToReproduce;
    }

    public Class<?> getFood() {
        return food;
    }

    public void makeMove(WorldMap worldMap) {
        if (health < maxHealth) {
            setWishToReproduce(false);
        }
        stepsLeft = this.getSpeed();
        ateThisTurn = false;
        PathBuilder pathBuilder = new PathBuilder(worldMap, this);
        while (stepsLeft > 0) {
            List<Coordinate> path = pathBuilder.getPath();
            if (path.isEmpty()) {
                break;
            }
            path.removeLast();
            if (worldMap.isEmpty(path.getLast())) {
                takeStep(worldMap, path.getLast());
            } else if (worldMap.get(path.getLast()).getClass() == this.food) {
                eat(worldMap, path.getLast());
                break;
            } else if (worldMap.get(path.getLast()).getClass() == this.getClass() && isWishToReproduce && ((Creature) worldMap.get(path.getLast())).isWishToReproduce()) {
                reproduce(worldMap);
                break;
            }
//            else {stepsLeft--;}
//            System.out.println(path);
//            MapPrinter mapPrinter = new MapPrinter(worldMap);
//            mapPrinter.printMap();
//            System.out.println();
        }
        if (!ateThisTurn) {
            levelOfHunger++;
        }
        switch (levelOfHunger) {
            case 0, 1 -> setWishToReproduce(true);
            case 2, 3, 4 -> setWishToReproduce(false);
            default -> {
                setWishToReproduce(false);
                reduceHealth(1);
            }
        }
        if (health <= 0) {
            this.isAlive = false;
            worldMap.remove(worldMap.getCoordinate(this));
        }
//        && ((Creature) worldMap.get(path.getLast())).isWishToReproduce()
//        if (levelOfHunger < 2) {
//            isWishToReproduce = true;
//        } else if (levelOfHunger >= 3) {
//            isWishToReproduce = false;
//            reduceHealth(1);
//        }
    }

    protected void takeStep(WorldMap worldMap, Coordinate coordinate) {
        Coordinate from = worldMap.getCoordinate(this);
        worldMap.put(coordinate, this);
        worldMap.remove(from);
        stepsLeft--;
    }

    protected abstract void reproduce(WorldMap worldMap);

    protected abstract void eat(WorldMap worldMap, Coordinate coordinate);
}
