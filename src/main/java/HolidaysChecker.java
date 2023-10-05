import java.time.LocalDate;
import java.time.MonthDay;
import java.util.HashSet;
import java.util.Set;

public class HolidaysChecker {
    private final Set<MonthDay> publicHolidays;

    public HolidaysChecker() {
        publicHolidays = new HashSet<>();
        publicHolidays.add(MonthDay.of(1, 1));   // New Year's Day
        publicHolidays.add(MonthDay.of(12, 25)); // Christmas Day
        publicHolidays.add(MonthDay.of(12, 26)); // Boxing Day
        publicHolidays.add(MonthDay.of(5, 1));   // Labour Day
        publicHolidays.add(MonthDay.of(5, 2));   // Labour Day
        publicHolidays.add(MonthDay.of(5, 3));   // Labour Day
        publicHolidays.add(MonthDay.of(8, 24));  // Independence Day
        publicHolidays.add(MonthDay.of(10, 14)); // Defender of Ukraine Day
        publicHolidays.add(MonthDay.of(6,28));  // Constitution Day
        // Add more public holidays as needed
    }

    public boolean isWorkingDay(LocalDate dateToCheck) {
        return !publicHolidays.contains(MonthDay.of(dateToCheck.getMonth(), dateToCheck.getDayOfMonth()));
    }
}