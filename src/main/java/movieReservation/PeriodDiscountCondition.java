package movieReservation;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodDiscountCondition implements DiscountCondition {

    private final DayOfWeek dayOfWeek;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public PeriodDiscountCondition(final DayOfWeek dayOfWeek, final LocalTime startTime, final LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                startTime.isAfter(screening.getWhenScreened().toLocalTime()) &&
                endTime.isBefore(screening.getWhenScreened().toLocalTime());
    }
}
