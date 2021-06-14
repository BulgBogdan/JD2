package bogdan.hql.realization;

import bogdan.hql.entity.Seller;
import bogdan.hql.entity.Shop;

import java.util.List;
import java.util.Random;

public class SellerUtil {

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

    public static Seller getSeller(List<Shop> shops) {
        Random random = new Random();
        int getShop = (int) (Math.random() * shops.size());
        Shop shop = shops.get(getShop);
        return Seller.builder()
                .firstName(getRandomName())
                .lastName(getRandomSurName())
                .salary(random.nextInt(1000) + 100)
                .shop(shop)
                .build();
    }

}
