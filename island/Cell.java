package island;

import island.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {

    private int raw;
    private int column;
    private List<Wolf> wolfs;
    private List<Boa> boas;
    private List<Fox> foxes;
    private List<Bear> bears;
    private List<Eagle> eagles;
    private List<Horse> horses;
    private List<Deer> deer;
    private List<Rabbit> rabbits;
    private List<Mouse> mouses;
    private List<Goat> goats;
    private List<Sheep> sheep;
    private List<Boar> boars;
    private List<Buffalo> buffalo;
    private List<Duck> ducks;
    private List<Caterpillar> caterpillars;
    private List<Plant> plants;
    public static final HashMap<String, Integer> MAX_NUMBER_PER_CELL = new HashMap<>();

    static {
        MAX_NUMBER_PER_CELL.put("Wolf", 30);
        MAX_NUMBER_PER_CELL.put("Boa", 30);
        MAX_NUMBER_PER_CELL.put("Fox", 30);
        MAX_NUMBER_PER_CELL.put("Bear", 5);
        MAX_NUMBER_PER_CELL.put("Eagle", 20);
        MAX_NUMBER_PER_CELL.put("Horse", 20);
        MAX_NUMBER_PER_CELL.put("Deer", 20);
        MAX_NUMBER_PER_CELL.put("Rabbit", 150);
        MAX_NUMBER_PER_CELL.put("Mouse", 500);
        MAX_NUMBER_PER_CELL.put("Goat", 140);
        MAX_NUMBER_PER_CELL.put("Sheep", 140);
        MAX_NUMBER_PER_CELL.put("Boar", 50);
        MAX_NUMBER_PER_CELL.put("Buffalo", 10);
        MAX_NUMBER_PER_CELL.put("Duck", 200);
        MAX_NUMBER_PER_CELL.put("Caterpillar", 1000);
        MAX_NUMBER_PER_CELL.put("Plant", 200);
    }

    public Cell(int raw, int column) {
        this.raw = raw;
        this.column = column;
        this.wolfs = initCreatureList(Wolf.class);
        this.boas = initCreatureList(Boa.class);
        this.foxes = initCreatureList(Fox.class);
        this.bears = initCreatureList(Bear.class);
        this.eagles = initCreatureList(Eagle.class);
        this.horses = initCreatureList(Horse.class);
        this.deer = initCreatureList(Deer.class);
        this.rabbits = initCreatureList(Rabbit.class);
        this.mouses = initCreatureList(Mouse.class);
        this.goats = initCreatureList(Goat.class);
        this.sheep = initCreatureList(Sheep.class);
        this.boars = initCreatureList(Boar.class);
        this.buffalo = initCreatureList(Buffalo.class);
        this.ducks = initCreatureList(Duck.class);
        this.caterpillars = initCreatureList(Caterpillar.class);
        this.plants = initCreatureList(Plant.class);
    }

    public <T extends Creature> List<T> initCreatureList(Class<T> clazz) {// можно убрать рандом в отдельный метод
        List<T> listOfCreature = new ArrayList<>();
        String className = clazz.getSimpleName();
        Integer value = MAX_NUMBER_PER_CELL.get(className);
        int size = ThreadLocalRandom.current().nextInt(0, value + 1);
        try {
            for (int i = 0; i < size; i++) {
                if (clazz.equals(Plant.class)) {
                    listOfCreature.add(clazz.getConstructor().newInstance());
                } else {
                    listOfCreature.add(clazz.getConstructor(double.class).newInstance(Animal.HP.get(className) / 2));
                }
            }
        } catch (InstantiationException | IllegalAccessException |
                 NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Failed to create instances of " + clazz.getName(), e);
        }
        return listOfCreature;
    }


    public List<Creature> getCreatureList() {
        List<Creature> creatureList = new ArrayList<>();
        creatureList.addAll(getAnimalList());
        creatureList.addAll(plants);
        return creatureList;
    }

    public Map<String, Integer> getMapOfCreatures() {
        Map<String, Integer> mapOfCreatures = new HashMap<>();
        for (Animal animal : getAnimalList()) {
            String className = animal.getEmoji();
            mapOfCreatures.put(className, mapOfCreatures.getOrDefault(className, 0) + 1);
        }
        mapOfCreatures.put(getPlants().get(0).getEmoji(), getPlants().size());
        System.out.println(mapOfCreatures);
        return mapOfCreatures;
    }

    public List<Animal> getAnimalList() {
        List<Animal> animalList = new ArrayList<>();
        animalList.addAll(wolfs);
        animalList.addAll(boas);
        animalList.addAll(foxes);
        animalList.addAll(bears);
        animalList.addAll(eagles);
        animalList.addAll(horses);
        animalList.addAll(deer);
        animalList.addAll(rabbits);
        animalList.addAll(mouses);
        animalList.addAll(goats);
        animalList.addAll(sheep);
        animalList.addAll(boars);
        animalList.addAll(buffalo);
        animalList.addAll(ducks);
        animalList.addAll(caterpillars);
        return animalList;
    }

    public void addAnimal(Animal animal) {
        Double valueHP = Animal.HP.get(animal.getClass().getSimpleName());

        if (animal instanceof Buffalo) {
            this.getBuffalo().add(new Buffalo(valueHP));
        }
        if (animal instanceof Caterpillar) {
            this.getCaterpillars().add(new Caterpillar(valueHP));
        }
        if (animal instanceof Deer) {
            this.getDeer().add(new Deer(valueHP));
        }
        if (animal instanceof Goat) {
            this.getGoats().add(new Goat(valueHP));
        }
        if (animal instanceof Horse) {
            this.getHorses().add(new Horse(valueHP));
        }
        if (animal instanceof Rabbit) {
            this.getRabbits().add(new Rabbit(valueHP));
        }
        if (animal instanceof Sheep) {
            this.getSheep().add(new Sheep(valueHP));
        }
        if (animal instanceof Wolf) {
            this.getWolfs().add(new Wolf(valueHP));
        }
        if (animal instanceof Fox) {
            this.getFoxes().add(new Fox(valueHP));
        }
        if (animal instanceof Eagle) {
            this.getEagles().add(new Eagle(valueHP));
        }
        if (animal instanceof Boa) {
            this.getBoas().add(new Boa(valueHP));
        }
        if (animal instanceof Bear) {
            this.getBears().add(new Bear(valueHP));
        }
        if (animal instanceof Boar) {
            this.getBoars().add(new Boar(valueHP));
        }
        if (animal instanceof Duck) {
            this.getDucks().add(new Duck(valueHP));
        }
        if (animal instanceof Mouse) {
            this.getMouses().add(new Mouse(valueHP));
        }
    }

    public void removeCreature(Creature creature) {

        if (creature instanceof Buffalo) {
            this.getBuffalo().remove(creature);
        }
        if (creature instanceof Caterpillar) {
            this.getCaterpillars().remove(creature);
        }
        if (creature instanceof Deer) {
            this.getDeer().remove(creature);
        }
        if (creature instanceof Goat) {
            this.getGoats().remove(creature);
        }
        if (creature instanceof Horse) {
            this.getHorses().remove(creature);
        }
        if (creature instanceof Rabbit) {
            this.getRabbits().remove(creature);
        }
        if (creature instanceof Sheep) {
            this.getSheep().remove(creature);
        }
        if (creature instanceof Wolf) {
            this.getWolfs().remove(creature);
        }
        if (creature instanceof Fox) {
            this.getFoxes().remove(creature);
        }
        if (creature instanceof Eagle) {
            this.getEagles().remove(creature);
        }
        if (creature instanceof Boa) {
            this.getBoas().remove(creature);
        }
        if (creature instanceof Bear) {
            this.getBears().remove(creature);
        }
        if (creature instanceof Boar) {
            this.getBoars().remove(creature);
        }
        if (creature instanceof Duck) {
            this.getDucks().remove(creature);
        }
        if (creature instanceof Mouse) {
            this.getMouses().remove(creature);
        }
        if (creature instanceof Plant) {
            this.getPlants().remove(creature);
        }
    }

    public int getRaw() {
        return raw;
    }

    public int getColumn() {
        return column;
    }

    public List<Wolf> getWolfs() {
        return wolfs;
    }

    public List<Boa> getBoas() {
        return boas;
    }

    public List<Fox> getFoxes() {
        return foxes;
    }

    public List<Bear> getBears() {
        return bears;
    }

    public List<Eagle> getEagles() {
        return eagles;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public List<Deer> getDeer() {
        return deer;
    }

    public List<Rabbit> getRabbits() {
        return rabbits;
    }

    public List<Mouse> getMouses() {
        return mouses;
    }

    public List<Goat> getGoats() {
        return goats;
    }

    public List<Sheep> getSheep() {
        return sheep;
    }

    public List<Boar> getBoars() {
        return boars;
    }

    public List<Buffalo> getBuffalo() {
        return buffalo;
    }

    public List<Duck> getDucks() {
        return ducks;
    }

    public List<Caterpillar> getCaterpillars() {
        return caterpillars;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "raw=" + raw +
                ", column=" + column +
                ", wolfs=" + wolfs +
                ", boas=" + boas +
                ", foxes=" + foxes +
                ", bears=" + bears +
                ", eagles=" + eagles +
                ", horses=" + horses +
                ", deer=" + deer +
                ", rabbits=" + rabbits +
                ", mouses=" + mouses +
                ", goats=" + goats +
                ", sheep=" + sheep +
                ", boars=" + boars +
                ", buffalo=" + buffalo +
                ", ducks=" + ducks +
                ", caterpillars=" + caterpillars +
                ", plants=" + plants +
                '}';
    }
}
