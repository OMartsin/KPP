package Shop.ShopSchedule;

import java.time.LocalTime;

public record WorkingHours(LocalTime openingTime, LocalTime closingTime) {

    @Override
    public String toString() {
        return openingTime + " - " + closingTime;
    }
}