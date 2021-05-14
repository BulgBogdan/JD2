package people.util;

import people.Person;

import java.util.Random;

public class PersonUtil {

    private static String getRandomName() {
        String[] names = {"Ivan", "Fedor", "Alex", "Boris", "Semen", "Vasya", "Kolya"};
        int randomName = (int) (Math.random() * 7);
        return names[randomName];
    }

    private static String getRandomSurName() {
        String[] names = {"Ivanov", "Fedorov", "Alexandrov", "Borisov", "Semenov", "Vasiliev", "Nikolaev"};
        int randomSurName = (int) (Math.random() * 7);
        return names[randomSurName];
    }

    public static Person getPerson() {
        Random random = new Random();
        return Person.builder()
                .age(random.nextInt(100) + 15)
                .name(getRandomName())
                .surname(getRandomSurName())
                .build();
    }
}