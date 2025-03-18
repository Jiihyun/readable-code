package cleancode.studycafe.tobe.io.provider;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPasses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LockerPassFileReaderTest {

    @DisplayName("파일을 읽어 사물함 이용권 목록을 가져올 수 있다.")
    @Test
    void test() {
        // given
        LockerPassFileReader lockerPassFileReader = new LockerPassFileReader();
        // when
        StudyCafeLockerPasses lockerPasses = lockerPassFileReader.getLockerPasses();
        // then
        assertAll(
                () -> assertThat(lockerPasses.findLockerPassBy(StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 2, 4000, 0.0))).isEmpty(),
                () -> assertThat(lockerPasses.findLockerPassBy(StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 1, 60000, 0.1))).isEmpty(),
                () -> assertThat(lockerPasses.findLockerPassBy(StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1))).isPresent());
    }

}
