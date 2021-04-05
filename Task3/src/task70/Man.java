package task70;

import java.util.Arrays;

public class Man {

    private String name;
    private int age;
    private double height;
    private double weight;

    public Man() {
    }

    public Man(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public void getAllInformationAboutMan() {
        System.out.println("Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}');
    }

    public String getIformation() {
        return "Man name - " + name + ", age = " + age + ".";
    }

    public void getPhysicalParameters() {
        System.out.println("Man height = " + height + ", weight = " + weight + ".");
    }

    public static void getInformation(Object object) {
        Class clazz = object.getClass();
        System.out.println("Имя класса: " + clazz);
        System.out.println("Поля класса: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Методы класса: " + Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println("Конструкторы класса: " + Arrays.toString(clazz.getConstructors()));
    }
}
