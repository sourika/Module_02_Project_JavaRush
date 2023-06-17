package island;

import island.Cell;

import java.util.HashMap;

public class Goat extends Herbivore {
    public final static String NAME = "goat";
    public final static String EMOJI = "\uD83D\uDC10";
    public final static int WEIGHT = 60;
    public final static int MAX_TRAVEL_SPEED = 3;
    public static final HashMap<String, Integer> PROBABILITY = new HashMap<>();

    static {
        PROBABILITY.put("Plant", 100);
    }

    private double hp;

    public Goat(double hp) {
        this.hp = hp;
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
    public void eat(Cell cell) {
        super.eat(cell);
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
        return "Goat{" +
                "hp=" + hp +
                '}';
    }
}
