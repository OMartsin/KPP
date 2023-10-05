package lab4.order;

import lab4.city.City;
import lab4.shop.OnlineShop;

import java.time.LocalDate;

public record Order (City cityOfDelivery, OnlineShop shop, boolean isExpress, LocalDate dateOfOrder) {

    @Override
    public String toString() {
        return "lab4.order.Order: " + "\n" +
                "City of delivery: " + cityOfDelivery + "\n" +
                "Shop: " + shop + "\n" +
                "Is express: " + isExpress + "\n" +
                "Date of order: " + dateOfOrder + "\n";
    }
}
