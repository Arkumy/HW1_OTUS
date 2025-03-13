package animals;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {

    private String name;
    private int age;
    private int weight;
    private String color;


    public Animal(String name, int age, int weight, String color){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color; // это конструктор, так правильно, но нужно сделать сеттеры по дз. какая разница?
    }



    public String getName(){
        return name;
    }


    public int getAge(){
        return age;
    }


    public int getWeight(){
        return  weight;
    }


    public String getColor(){
        return color;
    }

    public void say(){
        System.out.println("Я говорю");
    }

    public void go(){
        System.out.println("Я иду");
    }

    public void drink(){
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу %d кг, мой цвет - %s.",
                name, age, getPadej(age), weight, color);
    }

    private String getPadej(int age) {
        if (age % 10 == 1 && age % 100 != 11) {
            return "год";
        } else if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) {
            return "года";
        } else {
            return "лет";
        }
    }



}

