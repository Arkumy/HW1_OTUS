package animals;

public class Cat extends animals.Animal {


    public Cat(String name, int age, int weight, String color) {super(name, age, weight, color); // супер для вызова конструктора родителя
        }
    @Override
    public void say(){
        System.out.println("Мяу");
    }
}

