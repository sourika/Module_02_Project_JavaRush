package island;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Caterpillar extends Herbivore {
    public final static String NAME = "caterpillar";
    public final static String EMOJI = "\uD83D\uDC1B";
    public final static double WEIGHT = 0.01;
    public final static int MAX_TRAVEL_SPEED = 0;
    public static final HashMap<String, Integer> PROBABILITY = new HashMap<>();

    static {
        PROBABILITY.put("Plant", 100);
    }

    private double hp;

    public Caterpillar(double hp) {
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
    public void eat(Cell currentCell) {
                List<Plant> currentPlantList = currentCell.getPlants();
                if (!currentPlantList.isEmpty()) {
                    Plant randomPlant = currentPlantList.get(0);
                    String classNameFood = randomPlant.getClass().getSimpleName();
                        currentPlantList.remove(randomPlant);
                        System.out.println("The " + this.getClass().getSimpleName() + " ate " + classNameFood);
            } else {
                System.out.println("There is no food for the " + this.getClass().getSimpleName() + " , so it will reproduce");
                this.reproduce(currentCell);
            }
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
        return "Caterpillar{" +
                "hp=" + hp +
                '}';
    }
}
