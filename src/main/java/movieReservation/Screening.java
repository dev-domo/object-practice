package movieReservation;

import java.time.LocalDateTime;

public class Screening {

    // 책임을 결정하고, 책임 수행에 필요한 인스턴스 변수를 설정한다
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    // Creator : Screening은 Reservation을 생성할 책임을 갖는다
    // Reservation은 '예매하라'는 메시지를 수신한다
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    // Screening은 Movie에게 '영화 요금을 계산하라'는 메시지를 전송한다
    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }
}
