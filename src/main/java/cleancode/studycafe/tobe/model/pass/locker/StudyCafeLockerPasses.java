package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;

import java.util.List;
import java.util.Optional;

public class StudyCafeLockerPasses {

    private final List<StudyCafeLockerPass> studyCafeLockerPasses;

    public StudyCafeLockerPasses(final List<StudyCafeLockerPass> studyCafeLockerPasses) {
        this.studyCafeLockerPasses = studyCafeLockerPasses;
    }

    public Optional<StudyCafeLockerPass> findLockerPassBy(final StudyCafeSeatPass pass) {
        return studyCafeLockerPasses.stream()
                .filter(pass::isSameDurationType)
                .findFirst();
    }

}
