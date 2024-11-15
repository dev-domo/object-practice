package movieReservation;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
}
