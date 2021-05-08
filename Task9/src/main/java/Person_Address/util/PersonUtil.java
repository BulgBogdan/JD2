package Person_Address.util;

import Person_Address.Address;
import Person_Address.Person;

import java.util.List;
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

    private static int getAddress(List<Address> addresses) {
        int[] values = new int[addresses.size()];
        int value = 0;
        for (Address address : addresses) {
            values[value] = address.getId();
            value++;
        }

        return values[(int) (Math.random() * values.length)];
    }

    public static Person getPerson(List<Address> addresses) {
        Random random = new Random();
        int address = getAddress(addresses);
        return Person.builder()
                .age(random.nextInt(100) + 15)
                .name(getRandomName())
                .surname(getRandomSurName())
                .id_address(address)
                .build();
    }
}