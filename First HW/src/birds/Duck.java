package birds; // Обновили пакет

import animals.Animal;
import tools.iFlying; // Исправили путь к интерфейсу

public class Duck extends Animal implements iFlying {
    public Duck(String name, int age, int weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public void say() {
        System.out.println("Кря");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }
}
