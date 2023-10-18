package lab4.shop;

import lab4.CityTimeZoneMapper;
import lab4.city.City;
import lab4.shop.shedule.ShopSchedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ShopsGenerator {
    private static final String[] SHOP_GENERIC_NAMES = {"SuperMart", "MegaStore", "QuickShop", "GroceryGalore", "FreshFoods"};
    private static final String[] SHOP_SPECIFIC_NAMES = {"Marry`s", "Jack`s", "Peter`s", "John`s", "Mark`s"};
    private static final Random RANDOM = new Random();

    public static List<OnlineShop> generateShops(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("Count must be greater than 0");
        }
        return new LinkedList<>() {
            {
                for (int i = 0; i < count; i++) {
                    add(generateRandomShop());
                }
            }
        };
    }

    private static OnlineShop generateRandomShop() {
        String cityName = CityTimeZoneMapper.CITIES[RANDOM.nextInt(CityTimeZoneMapper.CITIES.length)];
        String storeName = SHOP_SPECIFIC_NAMES[RANDOM.nextInt(SHOP_SPECIFIC_NAMES.length)] + " "
                + SHOP_GENERIC_NAMES[RANDOM.nextInt(SHOP_GENERIC_NAMES.length)];
        ShopSchedule schedule = generateRandomSchedule();
        City city = new City(cityName, CityTimeZoneMapper.getZoneIdByCityName(cityName));
        return new OnlineShop(storeName, schedule, city);
    }

    private static ShopSchedule generateRandomSchedule() {
        ShopSchedule schedule = new ShopSchedule();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if(RANDOM.nextBoolean()) {
                continue;
            }
            LocalTime openingTime = LocalTime.of(RANDOM.nextInt(12) + 1, 0);
            LocalTime closingTime = LocalTime.of(RANDOM.nextInt(11) + 12, 0);

            schedule.addWorkingHours(dayOfWeek, openingTime, closingTime);
        }
        return schedule;
    }
}
