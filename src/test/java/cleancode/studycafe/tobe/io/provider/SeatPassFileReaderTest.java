package cleancode.studycafe.tobe.io.provider;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPasses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SeatPassFileReaderTest {

    @DisplayName("파일을 읽어 이용권 목록을 가져올 수 있다.")
    @Test
    void getSeatPasses() {
        // given
        SeatPassFileReader seatPassFileReader = new SeatPassFileReader();
        // when
        StudyCafeSeatPasses seatPasses = seatPassFileReader.getSeatPasses();
        // then
        assertAll(
                () -> assertThat(seatPasses.findPassBy(StudyCafePassType.HOURLY)).hasSize(6),
                () -> assertThat(seatPasses.findPassBy(StudyCafePassType.WEEKLY)).hasSize(5),
                () -> assertThat(seatPasses.findPassBy(StudyCafePassType.FIXED)).hasSize(2));
    }

}
