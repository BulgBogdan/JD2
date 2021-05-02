package people.util;

import people.Address;

import java.util.Random;

public class AddressUtil {

    private static String getRandomStreet() {
        String[] streets = {
                "Nezavisimosty", "Pobediteley", "Dzerzhinskogo",
                "Masherova", "Zhukova", "Lubimova",
                "Rokossovskogo", "Partizanskiy", "Pushkina"
        };
        int randomStreet = (int) (Math.random() * 9);
        return streets[randomStreet];
    }

    public static Address getAddress() {
        Random random = new Random();
        return Address.builder()
                .street(getRandomStreet())
                .house(random.nextInt(100) + 1)
                .build();
    }
}
