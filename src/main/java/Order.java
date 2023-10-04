import City.City;
import Shop.OnlineShop;

import java.time.LocalDate;

public record Order (City cityOfDelivery, OnlineShop shop, boolean isExpress, LocalDate dateOfOrder) {

    @Override
    public String toString() {
        return "Order: " + "\n" +
                "City of delivery: " + cityOfDelivery + "\n" +
                "Shop: " + shop + "\n" +
                "Is express: " + isExpress + "\n" +
                "Date of order: " + dateOfOrder + "\n";
    }
}
