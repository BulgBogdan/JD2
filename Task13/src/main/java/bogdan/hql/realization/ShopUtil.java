package bogdan.hql.realization;

import bogdan.hql.entity.Shop;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

public class ShopUtil {

    private static String getRandomAddress() {
        String[] streets = {
                "Nezavisimosty", "Pobediteley", "Dzerzhinskogo",
                "Masherova", "Zhukova", "Lubimova",
                "Rokossovskogo", "Partizanskiy", "Pushkina"
        };
        int randomStreet = (int) (Math.random() * 9);
        return streets[randomStreet];
    }

    private static String getRandomName() {
        String[] streets = {
                "Evroopt", "Gippo", "Prostore",
                "Green", "Sosedi", "Korona",
                "Vitalyr", "Mila", "Ostrov"
        };
        int randomStreet = (int) (Math.random() * 9);
        return streets[randomStreet];
    }

    public static Shop getShop() {
        Random random = new Random();
        return Shop.builder()
                .address(getRandomAddress())
                .name(getRandomName())
                .createdDate(Date.valueOf(LocalDate.now()))
                .profit(random.nextInt(10000) + 1000)
                .build();
    }
}
