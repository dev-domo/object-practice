package movieReservation;

public class SequenceDiscountCondition implements DiscountCondition {

    private final int sequence;

    public SequenceDiscountCondition(final int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }
}
