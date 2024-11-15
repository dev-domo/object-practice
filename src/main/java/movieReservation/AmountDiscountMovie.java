package movieReservation;

import java.time.Duration;

public class AmountDiscountMovie extends Movie {

    private final Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTime, Money fee, Money discountAmount,
                               DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    Money calculateDiscountAmount() {
        return discountAmount;
    }
}
