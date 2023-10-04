import City.City;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class CityTimeZoneMapper {

    public static final String[] CITIES = {"New York", "London", "Tokyo", "Paris", "Berlin", "Simferopol", "Norfolk", "Sydney"};
    private static final Map<String, String> CITY_TIMEZONES;

    static {
        CITY_TIMEZONES = new HashMap<>();
        CITY_TIMEZONES.put("New York", "America/New_York");
        CITY_TIMEZONES.put("London", "Europe/London");
        CITY_TIMEZONES.put("Tokyo", "Asia/Tokyo");
        CITY_TIMEZONES.put("Paris", "Europe/Paris");
        CITY_TIMEZONES.put("Berlin", "Europe/Berlin");
        CITY_TIMEZONES.put("Simferopol", "Europe/Kyiv");
        CITY_TIMEZONES.put("Norfolk", "Pacific/Norfolk");
        CITY_TIMEZONES.put("Sydney", "Australia/Sydney");
    }

    public static City getCityByCityName(String name) {
        return new City(name, ZoneId.of(CITY_TIMEZONES.get(name)));
    }

    public static ZoneId getZoneIdByCityName(String name) {
        return ZoneId.of(CITY_TIMEZONES.get(name));
    }
}
