package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeLockerPassesTest {

    @DisplayName("특정 이용권 타입을 지닌 이용권 목록을 가져올 수 있다.")
    @Test
    void findPassByPassType() {
        // given
        StudyCafePassType expectedLockerType = StudyCafePassType.FIXED;
        int expectedDuration = 12;

        StudyCafeLockerPass lockerPass1 = StudyCafeLockerPass.of(expectedLockerType, 4, 10000);
        StudyCafeLockerPass lockerPass2 = StudyCafeLockerPass.of(expectedLockerType, expectedDuration, 30000);
        List<StudyCafeLockerPass> lockerPasses = List.of(lockerPass1, lockerPass2);
        StudyCafeLockerPasses studyCafeLockerPasses = new StudyCafeLockerPasses(lockerPasses);

        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(expectedLockerType, expectedDuration, 700000, 0.15);
        // when
        Optional<StudyCafeLockerPass> result = studyCafeLockerPasses.findLockerPassBy(seatPass);
        // then
        assertThat(result)
            .isPresent()
            .get()
            .extracting(StudyCafeLockerPass::getPassType, StudyCafeLockerPass::getDuration)
            .containsExactly(expectedLockerType, expectedDuration);
    }

}
