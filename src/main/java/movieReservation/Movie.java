package movieReservation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {

    private final String title;
    private final Duration runningTime;
    private final Money fee;
    private final List<DiscountCondition> discountConditions;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    // Movie는 '영화 요금을 계산하라'는 메시지를 수신한다
    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    // Movie은 DiscountCondition에 isSatisfiedBy(할인 조건 충족하는지) 메시지를 전송한다
    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    // 할인 요금 계산
    abstract Money calculateDiscountAmount();

    public Money getFee() {
        return fee;
    }
}
