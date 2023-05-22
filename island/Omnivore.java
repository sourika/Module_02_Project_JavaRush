package island;

import island.Animal;
import island.Cell;
import island.Creature;
import island.Island;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Omnivore extends Animal {
    double valueHP = Animal.HP.get(this.getClass().getSimpleName());

    @Override
    public void eat(Cell currentCell) {
        double hp = getHp();
        HashMap<String, Integer> probabilityMap = getProbabilityMap();
        if (hp < valueHP) {
            List<Creature> currentCreatureList = currentCell.getCreatureList();
            List<Creature> foodList = new ArrayList<>();
            for (Creature creature : currentCreatureList) {
                String className = creature.getClass().getSimpleName();
                if (probabilityMap.containsKey(className)) {
                    foodList.add(creature);
                }
            }
            if (!foodList.isEmpty()) {
                int randomFoodNumber = ThreadLocalRandom.current().nextInt(0, foodList.size());
                Creature randomFood = foodList.get(randomFoodNumber);
                String classNameFood = randomFood.getClass().getSimpleName();
                Integer probability = probabilityMap.get(classNameFood);
                int randomProbability = ThreadLocalRandom.current().nextInt(0, 100 + 1);
                if (randomProbability <= probability) {
                    hp = Math.min((randomFood.getWeight() + hp), valueHP);
                    this.setHp(hp);
                    currentCell.removeCreature(randomFood);
                    System.out.println("The " + this.getClass().getSimpleName() + " ate " + classNameFood);
                } else {
                    hp = hp - valueHP * Animal.HP_LOSS;
                    this.setHp(hp);
                    System.out.print("The " + this.getClass().getSimpleName() + " didn't eat " + classNameFood);
                    if (hp <= 0) {
                        currentCell.removeCreature(this);
                        System.out.println("The " + this.getClass().getSimpleName() + " died ");
                    }
                }
            }
        } else {
            System.out.println("The " + this.getClass().getSimpleName() + " is fed, so it will reproduce");
            this.reproduce(currentCell);
        }
    }

    @Override
    public void reproduce(Cell currentCell) {
        List<Animal> breedingPartnerList = new ArrayList<>();
        for (Animal animal : currentCell.getAnimalList()) {
            if (animal.getClass().equals(this.getClass())) {
                breedingPartnerList.add(animal);
            }
        }
        if (breedingPartnerList.size() >= 2 && breedingPartnerList.size() < Cell.MAX_NUMBER_PER_CELL.get(this.getClass().getSimpleName())) {
            System.out.println("The " + this.getClass().getSimpleName() + " is born");
            currentCell.addAnimal(this);
        } else {
            System.out.println("The " + this.getClass().getSimpleName() + " can't reproduce, so it will move");
            this.relocate(currentCell);
        }
    }

    @Override
    public void relocate(Cell cell) {
        List<Cell> availableCells = getAvailableCells(cell);
        if (!availableCells.isEmpty()) {
            List<Cell> checkedCells = new ArrayList<>();
            for (Cell availableCell : availableCells) {
                List<Animal> animalList = availableCell.getAnimalList()
                        .stream().filter(e -> e.getClass().equals(this.getClass()))
                        .toList();
                int number = animalList.size();
                if (number < Cell.MAX_NUMBER_PER_CELL.get(this.getClass().getSimpleName())) {
                    checkedCells.add(availableCell);
                }
            }
            int randomCellNumber = ThreadLocalRandom.current().nextInt(0, checkedCells.size());
            Cell randomChosenCell = checkedCells.get(randomCellNumber);
            cell.removeCreature(this);
            randomChosenCell.addAnimal(this);
            System.out.println("The " + this.getClass().getSimpleName() + " moved to another cell");
        } else {
            System.out.println("There are no suitable cells to move the " + this.getClass().getSimpleName() + ". Another animal is selected and the action");
            Island.selectAction();
        }
    }

    public List<Cell> getAvailableCells(Cell cell) {
        int maxTravelSpeed = getMaxTravelSpeed();
        int rawCell = cell.getRaw();
        int columnCell = cell.getColumn();
        List<Cell> availableCells = new ArrayList<>();
        for (int i = 1; i <= maxTravelSpeed; i++) {
            if (rawCell + i < Island.getLength()) {
                availableCells.add(Island.getMatrix()[rawCell + i][columnCell]);
            }
            if (rawCell - i >= 0) {
                availableCells.add(Island.getMatrix()[rawCell - i][columnCell]);
            }
            if (columnCell + i < Island.getWidth()) {
                availableCells.add(Island.getMatrix()[rawCell][columnCell + i]);
            }
            if (columnCell - i >= 0) {
                availableCells.add(Island.getMatrix()[rawCell][columnCell - i]);
            }
        }
        return availableCells;
    }
}



