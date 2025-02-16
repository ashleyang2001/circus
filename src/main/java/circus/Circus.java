package circus;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Parrot;
import circus.animal.Tiger;
import circus.animal.Elephant;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        System.out.println(animals.length);
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

        Parrot perry = new Parrot("Perry");
        animalArrayList.add(perry);
        animalArrayList.add(new Elephant("Brute"));
        Duck andy = new Duck("Andy");
        animalArrayList.add(andy);

        //Substitutability allows to add specific animals to Animal ArrayList
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
        System.out.println(animalArrayList.size());

        System.out.println("Perry is in position: " + animalArrayList.indexOf(perry));

        animalArrayList.sort(Animal.AnimalNameComparator);
        System.out.println("After Sorting:");
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }

        Elephant strongOne = new Elephant("StrongOne");
        animalArrayList.add(strongOne);
        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("LOUIE");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("DOLLY");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}
