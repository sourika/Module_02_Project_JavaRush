package island;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Plant extends Creature {
    public final static String EMOJI = "\uD83C\uDF31";
    public final static String NAME = "plant";
    public final static int WEIGHT = 1;


    public Plant() {
    }

    public static void grow() {

        List<Cell> cellList = Island.getCellList();
        int numberOfCells = (int) Math.ceil(cellList.size() * 0.15);
        for (int i = 0; i < numberOfCells; i++) {
            int randomCellNumber = ThreadLocalRandom.current().nextInt(0, cellList.size());
            Cell randomCell = cellList.get(randomCellNumber);
            randomCell.getPlants().add(new Plant());
        }
        System.out.println(numberOfCells + " new plants have grown on the island");
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
        return "Plant{}";
    }
}
