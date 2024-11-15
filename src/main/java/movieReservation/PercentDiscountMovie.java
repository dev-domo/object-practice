package movieReservation;

import java.time.Duration;

public class PercentDiscountMovie extends Movie {

    private final double percent;

    public PercentDiscountMovie(String title, Duration runningTime, Money fee, double percent,
                                DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.percent = percent;
    }

    @Override
    Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
