package island;

import island.Cell;
import island.Predator;

import java.util.HashMap;

public class Wolf extends Predator {
    public final static String NAME = "wolf";
    public final static String EMOJI = "\uD83D\uDC3A";
    public final static int WEIGHT = 50;
    public final static int MAX_TRAVEL_SPEED = 3;
    public static final HashMap<String, Integer> PROBABILITY = new HashMap<>();

    static {
        PROBABILITY.put("Horse", 10);
        PROBABILITY.put("Deer", 15);
        PROBABILITY.put("Rabbit", 60);
        PROBABILITY.put("Mouse", 80);
        PROBABILITY.put("Goat", 60);
        PROBABILITY.put("Sheep", 70);
        PROBABILITY.put("Boar", 15);
        PROBABILITY.put("Buffalo", 10);
        PROBABILITY.put("Duck", 40);
    }

    private double hp;

    public Wolf(double hp) {
        this.hp = hp;
    }


    @Override
    public void eat(Cell cell) {
        super.eat(cell);
    }

    @Override
    public void relocate(Cell cell) {
        super.relocate(cell);
    }

    @Override
    public void reproduce(Cell cell) {
        super.reproduce(cell);
    }

    @Override
    public int getMaxTravelSpeed() {
        return MAX_TRAVEL_SPEED;
    }

    @Override
    public double getHp() {
        return hp;
    }

    @Override
    public void setHp(double hp) {
        this.hp = hp;
    }

    @Override
    public HashMap<String, Integer> getProbabilityMap() {
        return PROBABILITY;
    }


    @Override
    public String getEmoji() {
        return EMOJI;
    }

    @Override
    public double getWeight() {
        return WEIGHT;
    }


    @Override
    public String toString() {
        return "Wolf{" +
                "hp=" + hp +
                '}';
    }
}