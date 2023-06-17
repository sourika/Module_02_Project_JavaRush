package island;

import island.Cell;

import java.util.HashMap;

public class Eagle extends Predator {
    public final static String NAME = "eagle";
    public final static String EMOJI = "\uD83E\uDD85";
    public final static int WEIGHT = 6;
    public final static int MAX_TRAVEL_SPEED = 3;
    public static final HashMap<String, Integer> PROBABILITY = new HashMap<>();

    static {
        PROBABILITY.put("Fox", 10);
        PROBABILITY.put("Rabbit", 90);
        PROBABILITY.put("Mouse", 90);
        PROBABILITY.put("Duck", 80);
    }

    private double hp;

    public Eagle(double hp) {
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
        return "Eagle{" +
                "hp=" + hp +
                '}';
    }
}
