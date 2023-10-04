import Shop.OnlineShop;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class OrderConsoleRider {
    public static Order getOrder(List<OnlineShop> shops) {
        Scanner scanner = new Scanner(System.in);
        OnlineShop selectedShop = selectShop(shops, scanner);
        String userCity = selectCity(scanner);
        LocalDate orderDate = selectOrderDate(scanner);
        boolean isExpress = selectDeliveryType(scanner);
        return new Order(CityTimeZoneMapper.getCityByCityName(userCity), selectedShop, isExpress, orderDate);
    }

    private static OnlineShop selectShop(List<OnlineShop> shops, Scanner scanner) {
        while (true) {
            System.out.println("Available shops:");
            shops.forEach(shop -> System.out.println(shops.indexOf(shop) + ": " + shop.toString()));
            System.out.print("Enter the number of the shop for the order: ");
            int shopIndex = scanner.nextInt();
            if (shopIndex >= 0 && shopIndex < shops.size()) {
                return shops.get(shopIndex);
            } else {
                System.out.println("Invalid shop number. Please try again.");
            }
        }
    }

    private static String selectCity(Scanner scanner) {
        while (true) {
            System.out.println("Available cities:");
            for (int i = 0; i < CityTimeZoneMapper.CITIES.length; i++) {
                System.out.println(i + ": " + CityTimeZoneMapper.CITIES[i]);
            }
            System.out.print("Enter the number of your city: ");
            int cityIndex = scanner.nextInt();
            if (cityIndex >= 0 && cityIndex < CityTimeZoneMapper.CITIES.length) {
                return CityTimeZoneMapper.CITIES[cityIndex];
            } else {
                System.out.println("Invalid city number. Please try again.");
            }
        }
    }

    private static LocalDate selectOrderDate(Scanner scanner) {
        while (true) {
            System.out.print("Enter the order date (yyyy-mm-dd): ");
            String inputDate = scanner.next();
            try {
                LocalDate orderDate = LocalDate.parse(inputDate);
                if (orderDate.isAfter(LocalDate.now()) || orderDate.isEqual(LocalDate.now())) {
                    return orderDate;
                } else {
                    System.out.println("Invalid order date. It should be today or a future date. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
    }

    private static boolean selectDeliveryType(Scanner scanner) {
        while (true) {
            System.out.print("Is it an express delivery? (yes/no): ");
            String input = scanner.next().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
