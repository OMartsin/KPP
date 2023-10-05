package lab4.shop.ShopSchedule;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumMap;

public class ShopSchedule {
    private EnumMap<DayOfWeek, WorkingHours> schedule;

    public ShopSchedule() {
        schedule = new EnumMap<>(DayOfWeek.class);
    }

    public void addWorkingHours(DayOfWeek dayOfWeek, LocalTime openingTime, LocalTime closingTime) {
        schedule.put(dayOfWeek, new WorkingHours(openingTime, closingTime));
    }

    public WorkingHours getWorkingHours(DayOfWeek dayOfWeek) {
        return schedule.get(dayOfWeek);
    }

    public boolean isWorkingDay(LocalDate dayOfWeek) {
        return schedule.containsKey(dayOfWeek.getDayOfWeek());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nShop schedule:\n");
        for (DayOfWeek dayOfWeek : schedule.keySet()) {
            sb.append(dayOfWeek.toString()).append(": ").append(schedule.get(dayOfWeek).toString()).append("\n");
        }
        return sb.toString();
    }

}