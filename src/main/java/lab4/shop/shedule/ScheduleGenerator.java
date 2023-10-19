package lab4.shop.shedule;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Random;

public class ScheduleGenerator {

    private static final Random RANDOM = new Random();
    public static CompanySchedule generateRandomSchedule() {
        CompanySchedule schedule = new CompanySchedule();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if(RANDOM.nextBoolean()) {
                continue;
            }
            LocalTime openingTime = LocalTime.of(RANDOM.nextInt(12) + 1, 0);
            LocalTime closingTime = LocalTime.of(RANDOM.nextInt(11) + 12, 0);

            schedule.addWorkingHours(dayOfWeek, openingTime, closingTime);
        }
        return schedule;
    }
}
