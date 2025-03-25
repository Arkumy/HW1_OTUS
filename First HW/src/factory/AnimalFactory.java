package factory;

import animals.Animal;
import animals.Cat;
import animals.Dog;
import birds.Duck;
import data.AnimalTypeData;

public class AnimalFactory {
    public static Animal create(String name, int age, int weight, String color, AnimalTypeData animalTypeData) {
        switch (animalTypeData) {
            case CAT:
                return new Cat(name, age, weight, color);
            case DOG:
                return new Dog(name, age, weight, color);
            case DUCK:
                return new Duck(name, age, weight, color);
            default:
                throw new IllegalArgumentException("Неизвестный тип животного: " + animalTypeData);
        }
    }
}
