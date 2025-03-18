package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeSeatPassTest {

    @ParameterizedTest
    @CsvSource({
            "HOURLY, HOURLY, true",
            "HOURLY, WEEKLY, false"
    })
    @DisplayName("이용권 내 이용권 타입이 비교하는 타입과 같은지 비교할 수 있다.")
    void isSamePassType(StudyCafePassType passType, StudyCafePassType expectedPassType, boolean expectedResult) {
        // given
        StudyCafeSeatPass pass = StudyCafeSeatPass.of(passType, 2, 4000, 0.0);
        // when
        boolean result = pass.isSamePassType(expectedPassType);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("사물함 타입과 같은 기간 및 이용권 타입을 가지면 true를 반환한다.")
    @Test
    void isSameDurationType() {
        // given
        StudyCafePassType expectedPassType = StudyCafePassType.HOURLY;
        int duration = 2;
        int price = 4000;

        StudyCafeSeatPass pass = StudyCafeSeatPass.of(expectedPassType, duration, price, 0.0);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(expectedPassType, duration, price);
        // when
        boolean result = pass.isSameDurationType(lockerPass);
        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "HOURLY, true",
            "WEEKLY, true",
            "FIXED, false"
    })
    @DisplayName("이용권마다 사물함 이용 가능 여부를 확인한다.")
    void cannotUseLocker(StudyCafePassType passType, boolean expectedResult) {
        // given
        StudyCafeSeatPass pass = StudyCafeSeatPass.of(passType, 2, 4000, 0.0);
        // when
        boolean result = pass.cannotUseLocker();
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("좌석 이용권마다 할인된 가격을 구할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"400000, 0.15, 60000", "250000, 0.1, 25000"})
    void getDiscountPrice(int price, double discountRate, int resultDiscountPrice) {
        // given
        StudyCafePassType expectedPassType = StudyCafePassType.FIXED;
        StudyCafeSeatPass pass = StudyCafeSeatPass.of(expectedPassType, 2, price, discountRate);
        // when
        int discountPrice = pass.getDiscountPrice();
        // then
        assertThat(discountPrice).isEqualTo(resultDiscountPrice);
    }
}
