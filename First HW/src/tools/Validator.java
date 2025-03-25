package tools;

import java.util.Scanner;

public class Validator {
    public static int getValidNumber(Scanner sc, String message) {
        int age;
        while (true) {
            System.out.println(message);
            String input = sc.nextLine().trim();
            if (input.matches("[1-9]\\d?|100")) { //строка содержит хотя бы одну цифру и это только цифры. регулярка
                return Integer.parseInt(input); //преобразуем строку в цифру

            }
            System.out.println("Ошибка: введите цифру 1 до 100.");
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

    public static String getValidName(Scanner sc, String message) {
        while (true) {
            System.out.println(message);
            String name = sc.nextLine().trim();
            if (!name.isEmpty()) { // Проверяем, что имя не пустое
                return name;
            }
            System.out.println("Ошибка: имя не может быть пустым.");
        }
    }

}
