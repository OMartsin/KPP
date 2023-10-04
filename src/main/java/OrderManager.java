import Shop.OnlineShop;

import java.util.List;

public class OrderManager {
    public static void run() {
        List<OnlineShop> shops = ShopsGenerator.generateShops(5);
        var order = OrderConsoleRider.getOrder(shops);
        System.out.println("Order created successfully:\n" + order);
        System.out.println("Expected delivery date of your order is: ");
        System.out.println(OrderDeliveryTimeCalculator.calculateDeliveryDate(order));
    }
}
