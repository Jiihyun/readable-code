package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StudyCafeSeatPassesTest {

    @DisplayName("특정 이용권 타입을 지닌 이용권 목록을 가져올 수 있다.")
    @Test
    void findPassByPassType() {
        // given
        StudyCafePassType hourlyPassType = StudyCafePassType.HOURLY;
        StudyCafePassType weeklyPassType = StudyCafePassType.WEEKLY;

        StudyCafeSeatPass hourlyPass1 = StudyCafeSeatPass.of(hourlyPassType, 2, 4000, 0.0);
        StudyCafeSeatPass hourlyPass2 = StudyCafeSeatPass.of(hourlyPassType, 4, 6500, 0.0);
        StudyCafeSeatPass weeklyPass = StudyCafeSeatPass.of(weeklyPassType, 1, 6000, 0.0);
        List<StudyCafeSeatPass> seatPasses = List.of(hourlyPass1, hourlyPass2, weeklyPass);

        StudyCafeSeatPasses studyCafeSeatPasses = new StudyCafeSeatPasses(seatPasses);
        // when
        List<StudyCafeSeatPass> passes = studyCafeSeatPasses.findPassBy(hourlyPassType);
        // then
        assertAll(
                () -> assertThat(passes).hasSize(2),
                () -> assertThat(passes)
                        .allMatch(pass -> pass.getPassType() == hourlyPassType)
        );
    }

}
