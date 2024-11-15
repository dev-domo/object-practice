package movieReservation;

import java.time.Duration;

public class NoneDiscountMovie extends Movie {

    public NoneDiscountMovie(String title, Duration runningTime, Money fee,
                             DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
    }

    @Override
    Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
