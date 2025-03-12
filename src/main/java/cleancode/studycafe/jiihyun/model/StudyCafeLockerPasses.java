package cleancode.studycafe.jiihyun.model;

import cleancode.studycafe.jiihyun.exception.AppException;

import java.util.List;

public class StudyCafeLockerPasses {

    private final List<StudyCafeLockerPass> studyCafeLockerPasses;

    public StudyCafeLockerPasses(final List<StudyCafeLockerPass> studyCafeLockerPasses) {
        this.studyCafeLockerPasses = studyCafeLockerPasses;
    }

    public StudyCafeLockerPass getLockerPassByCafePassTypeAndDuration(final StudyCafePass selectedPass) {
        return studyCafeLockerPasses.stream()
                .filter(option -> option.isSamePassTypeAndDuration(selectedPass))
                .findFirst()
                .orElseThrow(() -> new AppException("조건에 맞는 사물함이 없습니다."));
    }
}
