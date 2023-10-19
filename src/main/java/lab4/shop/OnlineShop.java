package lab4.shop;
import lab4.shop.shedule.CompanySchedule;
import lab4.city.City;

public class OnlineShop {
    private final String name;
    private final CompanySchedule companySchedule;
    private final City city;

    public OnlineShop(String name, CompanySchedule companySchedule, City city) {
        this.name = name;
        this.companySchedule = companySchedule;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public CompanySchedule getShopSchedule() {
        return companySchedule;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name + " " + city.toString() + " " + companySchedule.toString();
    }
}
