package island;

import java.util.HashMap;

public class Boar extends Omnivore {
    public final static String NAME = "boar";
    public final static String EMOJI = "\uD83D\uDC17";
    public final static int WEIGHT = 400;
    public final static int MAX_TRAVEL_SPEED = 2;
    public static final HashMap<String, Integer> PROBABILITY = new HashMap<>();

    static {
        PROBABILITY.put("Mouse", 50);
        PROBABILITY.put("Caterpillar", 90);
        PROBABILITY.put("Plant", 100);
    }

    private double hp;

    public Boar(double hp) {
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
        return "Boar{" +
                "hp=" + hp +
                '}';
    }
}
