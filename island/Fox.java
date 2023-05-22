package island;

import island.Cell;

import java.util.HashMap;


public class Fox extends Predator {
    public final static String NAME = "fox";
    public final static String emoji = "\uD83E\uDD8A";
    public final static int WEIGHT = 8;
    public final static int MAX_TRAVEL_SPEED = 2;
    public static final HashMap<String, Integer> PROBABILITY = new HashMap<>();

    static {
        PROBABILITY.put("Rabbit", 70);
        PROBABILITY.put("Mouse", 90);
        PROBABILITY.put("Duck", 60);
        PROBABILITY.put("Caterpillar", 40);
    }

    private double hp;

    public Fox(double hp) {
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
        return emoji;
    }

    public double getWeight() {
        return WEIGHT;
    }

    @Override
    public String toString() {
        return "Fox{" +
                "hp=" + hp +
                '}';
    }
}
