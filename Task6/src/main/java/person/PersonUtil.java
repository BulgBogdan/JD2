package person;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonUtil {

    static String getRandomName() {
        String[] names = {"Ivan", "Fedor", "Alex", "Boris", "Semen", "Vasya", "Kolya"};
        int randomName = (int) (Math.random() * 7);
        return names[randomName];
    }

    static String getRandomSurName() {
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
            int id = i + 1;
            double salary = 200 + (1000 - 200) * random.nextDouble();
            String passport = "asdfghjkl1";
            String address = "city and street";
            Date birthday = Date.valueOf(LocalDate.now().minusYears(age).minusDays(i));
            Timestamp timeCreate = new Timestamp(Date.valueOf(LocalDate.now()).getTime());
            Timestamp timeLunch = new Timestamp(Date.valueOf(LocalDate.now()).getTime() + i);
            String letter = "text";
            Person person = new Person(
                    id, getRandomName(), getRandomSurName(), age, salary, passport,
                    address, birthday, timeCreate, timeLunch, letter);
            personList.add(person);
        }
        return personList;
    }
}