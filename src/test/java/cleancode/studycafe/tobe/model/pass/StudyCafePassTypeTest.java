package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassTypeTest {

    @DisplayName("사물함을 이용할 수 있는 이용권 타입인지 확인할 수 있다.")
    @ParameterizedTest()
    @MethodSource("provideLockerTypeTestCases")
    void isLockerType(StudyCafePassType passType, boolean expected) {
        // when
        boolean result = passType.isLockerType();
        // then
        assertThat(result).isEqualTo(expected);
    }


    @DisplayName("사물함을 이용할 수 없는 이용권 타입잍지 확인할 수 있다.")
    @ParameterizedTest()
    @MethodSource("provideLockerTypeTestCases")
    void isNotLockerType(StudyCafePassType passType, boolean expected) {
        // when
        boolean result = passType.isNotLockerType();
        // then
        assertThat(result).isNotEqualTo(expected);
    }

    private static Stream<Arguments> provideLockerTypeTestCases() {
        return Stream.of(
                Arguments.of(StudyCafePassType.HOURLY, false),
                Arguments.of(StudyCafePassType.WEEKLY, false),
                Arguments.of(StudyCafePassType.FIXED, true)
        );
    }
}
