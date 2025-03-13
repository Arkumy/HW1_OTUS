import animals.Animal;
import data.AnimalTypeData;
import data.AnimalFactory;
import tools.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду: add/list/exit");
            String command = sc.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    addAnimal(sc, animals);
                    break;
                case "list":
                    listAnimals(animals);
                    break;
                case "exit":
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }
    }

    private static void addAnimal(Scanner sc, List<Animal> animals) {
        System.out.println("Введите имя животного:");
        String name = sc.nextLine().trim();

        int age = Validator.getValidAge(sc, "Введите возраст (от 1 до 100):");
        int weight = Validator.getValidWeight(sc, "Введите вес (от 0 до 100):");
        String color = Validator.getValidColor(sc, "Введите цвет:");

        AnimalTypeData type = getValidAnimalType(sc);

        Animal animal = AnimalFactory.create(name, age, weight, color, type);
        animals.add(animal);

        System.out.println("Животное добавлено!");
        animal.say(); // Сразу говорим
    }

    private static AnimalTypeData getValidAnimalType(Scanner sc) {
        while (true) {
            System.out.println("Выберите тип животного (CAT, DOG, DUCK):");
            String input = sc.nextLine().trim().toUpperCase();

            try {
                return AnimalTypeData.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: введите корректное название (CAT, DOG, DUCK).");
            }
        }
    }

    private static void listAnimals(List<Animal> animals) {
        if (animals.isEmpty()) {
            System.out.println("Список животных пуст.");
        } else {
            for (Animal animal : animals) {
                System.out.println(animal);
            }
        }
    }
}
