package lab4.order;

import lab4.city.City;
import lab4.deliverycompany.DeliveryCompany;
import lab4.shop.OnlineShop;

import java.time.LocalDate;

public record Order (City cityOfDelivery, OnlineShop shop, boolean isExpress, DeliveryCompany deliveryCompany,
                     LocalDate dateOfOrder) {

    @Override
    public String toString() {
        return "Order: " + "\n" +
                "City of delivery: " + cityOfDelivery + "\n" +
                "Shop: " + shop + "\n" +
                "Is express: " + isExpress + "\n" +
                "Delivery company: " + deliveryCompany.name() + "\n" +
                "Date of order: " + dateOfOrder + "\n";
    }
}
