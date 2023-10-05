package lab4;

import lab4.order.handlers.OrderConsoleReader;
import lab4.order.handlers.OrderDeliveryTimeCalculator;
import lab4.shop.OnlineShop;
import lab4.shop.ShopsGenerator;

import java.util.List;

public class OrderAppRunner {
    public static void run() {
        List<OnlineShop> shops = ShopsGenerator.generateShops(5);
        var order = OrderConsoleReader.getOrder(shops);
        System.out.println("Order created successfully:\n" + order);
        System.out.println("Expected delivery date of your order is: ");
        System.out.println(OrderDeliveryTimeCalculator.calculateDeliveryDate(order));
    }
}
