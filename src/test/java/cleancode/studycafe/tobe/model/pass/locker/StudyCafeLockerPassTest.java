package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeLockerPassTest {

    @ParameterizedTest
    @CsvSource({
            "HOURLY, false",
            "WEEKLY, false",
            "FIXED, true"
    })
    @DisplayName("이용권 타입이 사물함 이용권 타입과 같은지 비교할 수 있다.")
    void isSamePassType(StudyCafePassType passType, boolean expectedResult) {
        // given
        StudyCafePassType lockerType = StudyCafePassType.FIXED;
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(lockerType, 4, 10000);
        // when
        boolean result = lockerPass.isSamePassType(passType);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("사물함 이용권의 기간과 같은 기간이면 true를 반환한다.")
    @Test
    void isSameDuration() {
        // given
        StudyCafePassType lockerType = StudyCafePassType.FIXED;
        int duration = 4;
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(lockerType, duration, 10000);
        // when
        boolean result = lockerPass.isSameDuration(duration);
        // then
        assertThat(result).isTrue();
    }

    @DisplayName("사물함 이용권의 기간과 다른 기간이면 false를 반환한다.")
    @Test
    void isNotSameDuration() {
        // given
        StudyCafePassType lockerType = StudyCafePassType.FIXED;
        int expectedDuration = 4;
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(lockerType, expectedDuration, 10000);
        int actualDuration = 12;
        // when
        boolean result = lockerPass.isSameDuration(actualDuration);
        // then
        assertThat(result).isFalse();
    }
}
