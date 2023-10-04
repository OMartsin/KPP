package City;

import java.time.ZoneId;
import java.time.ZoneOffset;

public record City(String name, ZoneId timeZone) {
    @Override
    public String toString() {
        ZoneOffset offset = timeZone.getRules().getOffset(java.time.Instant.now());
        return name + " " + timeZone.getId() + " (UTC: " + offset + ")" ;
    }

    public static City of(String name, ZoneId timeZone) {
        return new City(name, timeZone);
    }
}