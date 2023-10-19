package lab4.deliverycompany;

import lab4.CityTimeZoneMapper;
import lab4.shop.shedule.CompanySchedule;
import lab4.shop.shedule.ScheduleGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DeliveryCompaniesGenerator {
    private static final String[] SHOP_GENERIC_NAMES = {"POST", "Post", "Post Company", "Post LLC" };
    private static final String[] SHOP_SPECIFIC_NAMES = {"New", "FQ", "US", "John`s", "Mark`s"};
    private static final Random RANDOM = new Random();

    public static List<DeliveryCompany> generateCompanies(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("Count must be greater than 0");
        }
        return new LinkedList<>() {
            {
                for (int i = 0; i < count; i++) {
                    add(generateRandomCompany());
                }
            }
        };
    }

    private static DeliveryCompany generateRandomCompany() {
        String cityName = CityTimeZoneMapper.CITIES[RANDOM.nextInt(CityTimeZoneMapper.CITIES.length)];
        String storeName = SHOP_SPECIFIC_NAMES[RANDOM.nextInt(SHOP_SPECIFIC_NAMES.length)] + " "
                + SHOP_GENERIC_NAMES[RANDOM.nextInt(SHOP_GENERIC_NAMES.length)];
        CompanySchedule schedule = ScheduleGenerator.generateRandomSchedule();
        return new DeliveryCompany(storeName, schedule, RANDOM.nextInt(10000));
    }
}
