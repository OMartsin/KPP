import City.City;
import City.CityDistanceCalculator;
import Shop.OnlineShop;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class OrderDeliveryTimeCalculator {
    public static int TIME_DIFFERENCE_HOURS_FOR_SWITCHING_TO_NEXT_DAY = 5;
    public static int EXPRESS_DELIVERY_DISTANCE = 1000; // in km
    public static int REGULAR_DELIVERY_DISTANCE = 500; // in km
    public static LocalDate calculateDeliveryDate(Order order) {
        OnlineShop shop = order.shop();
        City deliveryCity = order.cityOfDelivery();
        double distance = CityDistanceCalculator.calculateDistance(shop.getCity(), order.cityOfDelivery());
        LocalDate currDay = order.dateOfOrder();
        currDay = currDay.plusDays(1); // add one day for processing

        HolidaysChecker holidaysChecker = new HolidaysChecker();
        while (distance > 0){
            if(isWorkingDay(currDay, holidaysChecker, shop)){
                if (order.isExpress()) {
                    distance -= EXPRESS_DELIVERY_DISTANCE;
                } else {
                    distance -= REGULAR_DELIVERY_DISTANCE;
                }
            }
            currDay = currDay.plusDays(1);
        }

        return addTimeZoneDifference(currDay, shop, deliveryCity);
    }

    private static LocalDate addTimeZoneDifference(LocalDate currDay, OnlineShop shop, City deliveryCity) {
        var dateOfInterest = LocalDateTime.parse("2020-02-02T12:00");
        var hours = ChronoUnit.HOURS.between(dateOfInterest.atZone(shop.getCity().timeZone())
                ,dateOfInterest.atZone(deliveryCity.timeZone()));
        if(Math.abs(hours) > TIME_DIFFERENCE_HOURS_FOR_SWITCHING_TO_NEXT_DAY){
            return currDay.plusDays((int)Math.signum(hours));
        }
        return currDay;
    }

    private static boolean isWorkingDay(LocalDate dateToCheck, HolidaysChecker holidaysChecker, OnlineShop shop) {
        return holidaysChecker.isWorkingDay(dateToCheck) && shop.getShopSchedule().isWorkingDay(dateToCheck);
    }
}
