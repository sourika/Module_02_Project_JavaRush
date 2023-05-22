package island;

import java.util.HashMap;

public abstract class Animal extends Creature {
    public final static double HP_LOSS = 0.1;
    public static final HashMap<String, Double> HP = new HashMap<>();

    static {
        HP.put("Wolf", 8.0);
        HP.put("Boa", 3.0);
        HP.put("Fox", 2.0);
        HP.put("Bear", 80.0);
        HP.put("Eagle", 1.0);
        HP.put("Horse", 60.0);
        HP.put("Deer", 50.0);
        HP.put("Rabbit", 0.45);
        HP.put("Mouse", 0.01);
        HP.put("Goat", 10.0);
        HP.put("Sheep", 15.0);
        HP.put("Boar", 50.0);
        HP.put("Buffalo", 100.0);
        HP.put("Duck", 0.15);
        HP.put("Caterpillar", 0.0);
    }

    public abstract void eat(Cell cell);

    public abstract void relocate(Cell cell);

    public abstract void reproduce(Cell cell);

    public abstract int getMaxTravelSpeed();

    public abstract double getHp();

    public abstract void setHp(double hp);

    public abstract HashMap<String, Integer> getProbabilityMap();

}
