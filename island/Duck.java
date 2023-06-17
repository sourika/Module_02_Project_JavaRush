package island;

import island.Cell;

import java.util.HashMap;

public class Duck extends Omnivore {
    public final static String NAME = "duck";
    public final static String EMOJI = "\uD83E\uDD86";
    public final static int WEIGHT = 1;
    public final static int MAX_TRAVEL_SPEED = 4;
    public static final HashMap<String, Integer> PROBABILITY = new HashMap<>();

    static {
        PROBABILITY.put("Caterpillar", 90);
        PROBABILITY.put("Plant", 100);
    }

    private double hp;

    public Duck(double hp) {
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
    public double getHp() {
        return hp;
    }

    @Override
    public void setHp(double hp) {
        this.hp = hp;
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
    public HashMap<String, Integer> getProbabilityMap() {
        return PROBABILITY;
    }

    @Override
    public int getMaxTravelSpeed() {
        return MAX_TRAVEL_SPEED;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "hp=" + hp +
                '}';
    }
}
