import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcardExample {
    static class Animal {
        public String getName() {
            return  "animal";
        }
    }

    static class Mammal extends Animal {
        public String getName() {
            return  "mammal";
        }
    }

    static class Dog extends Mammal {
        public String getName() {
            return  "dog";
        }
    }

    static class Cat extends Mammal {
        public String getName() {
            return  "cat";
        }
    }

    public static void addMammal(List<? super Mammal> list, Mammal mammal) {
        list.add(mammal);
    }

    public static void showMammals(List<Mammal> list) {
        System.out.print("Mammal : ");
        for(Mammal mammal : list) {
            System.out.print(mammal.getName() + " ");
        }
        System.out.println("");
    }

    public static void showAnimals(List<Animal> list) {
        System.out.print("Animal: ");
        for(Animal animal : list) {
            System.out.print(animal.getName() + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        List<Mammal> mammals = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();

        Dog dog = new Dog();
        Cat cat = new Cat();

        addMammal(mammals, dog);
        addMammal(mammals, cat);
        showMammals(mammals);
        addMammal(animals, dog);
        addMammal(animals, dog);
        showAnimals(animals);
    }
}