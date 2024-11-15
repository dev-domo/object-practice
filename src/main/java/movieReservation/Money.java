package movieReservation;

import java.math.BigDecimal;

public class Money {

    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    private static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money minus(Money money) {
        return new Money(this.amount.subtract(money.amount));
    }

    public Money times(double discountPercent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(discountPercent)));
    }
}
