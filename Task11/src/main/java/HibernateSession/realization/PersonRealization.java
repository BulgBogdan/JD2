package HibernateSession.realization;

import HibernateSession.entity.Address;
import HibernateSession.entity.Person;

import java.util.List;
import java.util.Random;

public class PersonRealization {

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

    public static Person getPerson(List<Address> addresses) {
        Random random = new Random();
        int getAddress = (int) (Math.random() * addresses.size());
        Address address = addresses.get(getAddress);
        return Person.builder()
                .age(random.nextInt(100) + 15)
                .name(getRandomName())
                .surname(getRandomSurName())
                .address(address)
                .build();
    }
}