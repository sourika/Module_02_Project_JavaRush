package island;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Island {
    public static final String LENGTH_QUESTION = "Set the length of the island";
    public static final String WIDTH_QUESTION = "Set the width of the island";

    private static final int LENGTH = IOOperation.enterFromConsole(LENGTH_QUESTION);
    private static final int WIDTH = IOOperation.enterFromConsole(WIDTH_QUESTION);

    private static final Cell[][] MATRIX = new Cell[LENGTH][WIDTH];

    static {
        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX[i].length; j++) {
                MATRIX[i][j] = new Cell(i, j);
            }
        }
    }

    private static volatile Island ISLAND;

    private Island() {

    }

    public static Island getInstance() {
        if (ISLAND == null) {
            synchronized (Island.class) {
                if (ISLAND == null) {
                    ISLAND = new Island();
                }
            }
        }
        return ISLAND;
    }

    public static void printMatrix() {
        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX[i].length; j++) {
                MATRIX[i][j].getMapOfCreatures();
            }
        }
    }


    public static void selectAction() {
        List<Cell> cellList = getCellList();
        int randomCellNumber = ThreadLocalRandom.current().nextInt(0, cellList.size());
        Cell randomCell = cellList.get(randomCellNumber);
        List<Animal> animals = randomCell.getAnimalList();
        int randomAnimalNumber = ThreadLocalRandom.current().nextInt(0, animals.size());
        Animal randomAnimal = animals.get(randomAnimalNumber);
        System.out.println("The " + randomAnimal + " is selected");
        int randomActionNumber = ThreadLocalRandom.current().nextInt(0, 3);
        switch (randomActionNumber) {
            case 0 -> randomAnimal.eat(randomCell);
            case 1 -> randomAnimal.reproduce(randomCell);
            case 2 -> randomAnimal.relocate(randomCell);
        }
    }

    public static List<Cell> getCellList() {
        List<Cell> cellList = new ArrayList<>();
        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX[i].length; j++) {
                cellList.add(MATRIX[i][j]);
            }
        }
        return cellList;
    }

    public static int getLength() {
        return LENGTH;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static Cell[][] getMatrix() {
        return MATRIX;
    }

}
