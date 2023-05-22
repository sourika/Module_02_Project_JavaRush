package island;

import java.util.HashMap;


public class Boa extends Predator {
    public final static String NAME = "boa";
    public final static String emoji = "\uD83D\uDC0D";
    public final static int WEIGHT = 15;
    public final static int MAX_TRAVEL_SPEED = 1;

    public static final HashMap<String, Integer> PROBABILITY = new HashMap<>();
    static {
        PROBABILITY.put("Fox", 15);
        PROBABILITY.put("Rabbit", 20);
        PROBABILITY.put("Mouse", 40);
        PROBABILITY.put("Duck", 10);
    }

    private double hp;

    public Boa(double hp) {
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

    @Override
    public double getWeight() {
        return WEIGHT;
    }


    @Override
    public String toString() {
        return "Boa{" +
                "hp=" + hp +
                '}';
    }
}
