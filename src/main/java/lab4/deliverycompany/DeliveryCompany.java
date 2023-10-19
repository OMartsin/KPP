package lab4.deliverycompany;

import lab4.shop.shedule.CompanySchedule;

public record DeliveryCompany(String name, CompanySchedule schedule, double distanceByDay){
    @Override
    public String toString(){
        return "Delivery company: " + "\n" +
                "Name: " + name + "\n" +
                "Schedule" + schedule.toString() + "\n" +
                "Speed: " + distanceByDay + "km by day" + "\n";
    }
}
