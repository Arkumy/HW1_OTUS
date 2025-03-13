package tools;

import java.util.Scanner;

public class Validator {
    public static int getValidAge(Scanner sc, String message) {
        int age;
        while (true) {
            System.out.println(message);
            String input = sc.nextLine().trim();
            if (input.matches("\\d+")) {
                age = Integer.parseInt(input);
                if (age >= 1 && age <= 100) {
                    return age;
                }
            }
            System.out.println("Ошибка: введите возраст от 1 до 100.");
        }
    }

    public static int getValidWeight(Scanner sc, String message) {
        int weight;
        while (true) {
            System.out.println(message);
            String input = sc.nextLine().trim();
            if (input.matches("\\d+")) {
                weight = Integer.parseInt(input);
                if (weight >= 0 && weight <= 100) {
                    return weight;
                }
            }
            System.out.println("Ошибка: введите вес от 10 до 99.");
        }
    }

    public static String getValidColor(Scanner sc, String message) {
        while (true) {
            System.out.println(message);
            String color = sc.nextLine().trim();
            if (color.matches("[а-яА-Яa-zA-Z]+")) {
                return color;
            }
            System.out.println("Ошибка: цвет должен содержать только буквы.");
        }
    }
}
