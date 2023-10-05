package lab4.city;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CityDistanceCalculator {
    public static final double DISTANCE_BETWEEN_TIMEZONE = 2000;
    public static double calculateDistance(City city1, City city2) {
        var dateOfInterest = LocalDateTime.parse("2020-02-02T12:00");
        var hours = ChronoUnit.HOURS.between(dateOfInterest.atZone(city1.timeZone())
                ,dateOfInterest.atZone(city2.timeZone()));
        double timeDifferenceHours = Math.abs(hours);
        return DISTANCE_BETWEEN_TIMEZONE * timeDifferenceHours;
    }
}
