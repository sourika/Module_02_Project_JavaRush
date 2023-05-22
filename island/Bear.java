package island;

import java.util.HashMap;

public class Bear extends Predator {

    public final static String NAME = "bear";
    public final static String emoji = "\uD83D\uDC3B";
    public final static int WEIGHT = 500;
    public final static int MAX_TRAVEL_SPEED = 2;
    public static final HashMap<String, Integer> PROBABILITY = new HashMap<>();
    static {
        PROBABILITY.put("Boa", 80);
        PROBABILITY.put("Horse", 40);
        PROBABILITY.put("Deer", 80);
        PROBABILITY.put("Rabbit", 80);
        PROBABILITY.put("Mouse", 90);
        PROBABILITY.put("Goat", 70);
        PROBABILITY.put("Sheep", 70);
        PROBABILITY.put("Boar", 50);
        PROBABILITY.put("Buffalo", 20);
        PROBABILITY.put("Duck", 10);
    }

    private double hp;

    public Bear(double hp) {
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
    public HashMap<String, Integer> getProbabilityMap() {
        return PROBABILITY;
    }

    @Override
    public String getEmoji() {
        return emoji;
    }

    @Override
    public double getWeight() {
        return WEIGHT;
    }

    @Override
    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Bear{" +
                "hp=" + hp +
                '}';
    }
}
