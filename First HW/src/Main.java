import animals.Animal;
import data.AnimalTypeData;
import factory.AnimalFactory;
import tools.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Animal> animals = new ArrayList<>(); // вынесли в свойства, чтобы принадлежали всему классу
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите команду: add/list/exit");
            String command = sc.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    addAnimal();
                    break;
                case "list":
                    listAnimals();
                    break;
                case "exit":
                    System.out.println("Выход из программы.");
                    return; // return тут нужен — он завершает весь метод main(), а значит, и работу всей программы,
                            //если будет break, то цикл будет работать бесконечно

                    default:
                        System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }
    }

    private static void addAnimal() {
        AnimalTypeData type = getValidAnimalType(); // тут не вызываем sc  потому что метод внутри класса в котором объявлена глоб переменная sc
        String name = Validator.getValidName(sc, "Введите имя животного:"); // тут вызываем потому что в валидаторе не объявлен sc
        int age = Validator.getValidNumber(sc, "Введите возраст:");
        int weight = Validator.getValidNumber(sc, "Введите вес:");
        String color = Validator.getValidColor(sc, "Введите цвет:");

        Animal animal = AnimalFactory.create(name, age, weight, color, type);
        animals.add(animal);

        System.out.println("Животное добавлено!");
        animal.say();
    }

    private static AnimalTypeData getValidAnimalType() {
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

    private static void listAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Список животных пуст.");
        } else {
            for (Animal animal : animals) {
                System.out.println(animal); // toString() по умолчанию есть у всех классов, потому что они наследуют его от
                // Object - прародитель всех классов, когда передаем объект в sout, он автоматически выберет toString - так заложено в правилах,
                // мы переопределили toString, чтобы не выводился хэш код, а вывелась нужная нам информация
            }
        }
    }
}
