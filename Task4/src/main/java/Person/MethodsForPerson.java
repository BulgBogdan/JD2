package Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MethodsForPerson {

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

    static List<Person> personList(int minAge, int maxAge) {
        List<Person> personList = new ArrayList<>();
        Random random = new Random();
        int diff = maxAge - minAge;
        for (int i = 0; i < 100; i++) {
            int age = random.nextInt(diff + 1) + minAge;
            Person person = new Person(getRandomName(), getRandomSurName(), age);
            personList.add(person);
        }
        return personList;
    }
}