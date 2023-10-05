package lab4.shop;
import lab4.shop.ShopSchedule.ShopSchedule;
import lab4.city.City;

public class OnlineShop {
    private final String name;
    private final ShopSchedule shopSchedule;
    private final City city;

    public OnlineShop(String name, ShopSchedule shopSchedule, City city) {
        this.name = name;
        this.shopSchedule = shopSchedule;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public ShopSchedule getShopSchedule() {
        return shopSchedule;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name + " " + city.toString() + " " + shopSchedule.toString();
    }
}
