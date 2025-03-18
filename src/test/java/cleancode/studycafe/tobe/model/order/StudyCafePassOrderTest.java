package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassOrderTest {

    @DisplayName("할인된 금액이 양수이면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 1000, 500000})
    void isPositivePrice(int discountPrice) {
        // given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 1, 60000, 0.1);
        StudyCafePassOrder studyCafePassOrder = new StudyCafePassOrder(studyCafeSeatPass, null);
        // when
        boolean isPositivePrice = studyCafePassOrder.isPositivePrice(discountPrice);
        // then
        assertThat(isPositivePrice).isTrue();
    }

     @DisplayName("할인된 금액이 0이거나 음수이면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100000})
    void isNotPositivePrice(int discountPrice) {
        // given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 1, 60000, 0.1);
        StudyCafePassOrder studyCafePassOrder = new StudyCafePassOrder(studyCafeSeatPass, null);
        // when
        boolean isPositivePrice = studyCafePassOrder.isPositivePrice(discountPrice);
        // then
        assertThat(isPositivePrice).isFalse();
    }

    @DisplayName("사물함을 이용하지 않는 이용권의 총금액을 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideSeatPassesWithoutLockerAndExpectedPrices")
    void getTotalPriceWithoutLockerPass(StudyCafeSeatPass seatPassWithoutLockerPass, int expectedTotalPrice) {
        // given
        StudyCafePassOrder studyCafePassOrder = new StudyCafePassOrder(seatPassWithoutLockerPass, null);
        // when
        int actualTotalPrice = studyCafePassOrder.getTotalPrice();
        // then
        assertThat(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    @DisplayName("사물함을 이용하는 이용권의 총금액을 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideSeatPassesWithLockerAndExpectedPrices")
    void getTotalPriceWithLockerPass(StudyCafeSeatPass seatPassWithLockerPass, StudyCafeLockerPass lockerPass, int expectedTotalPrice) {
        // given
        StudyCafePassOrder studyCafePassOrder = new StudyCafePassOrder(seatPassWithLockerPass, lockerPass);
        // when
        int actualTotalPrice = studyCafePassOrder.getTotalPrice();
        // then
        assertThat(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    private static Stream<Arguments> provideSeatPassesWithoutLockerAndExpectedPrices() {
        return Stream.of(
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 2, 4000, 0.0), 4000),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 6500, 0.0), 6500),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 6, 9000, 0.0), 9000),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 8, 11000, 0.0), 11000),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 10, 12000, 0.0), 12000),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 12, 13000, 0.0), 13000),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 1, 60000, 0.1), 54000),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1), 90000),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 3, 150000, 0.1), 135000),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 4, 400000, 0.1), 360000),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 12, 250000, 0.15), 212500),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1), 225000),
                Arguments.of(StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15), 595000)
        );
    }

    private static Stream<Arguments> provideSeatPassesWithLockerAndExpectedPrices() {
        return Stream.of(
                Arguments.of(
                        StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1),
                        StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000),
                        235000),
                Arguments.of(
                        StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15),
                        StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000),
                        625000)
        );
    }
}
