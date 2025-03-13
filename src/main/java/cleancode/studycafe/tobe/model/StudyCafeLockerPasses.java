package cleancode.studycafe.tobe.model;

import java.util.List;
import java.util.Optional;

public class StudyCafeLockerPasses {

    private final List<StudyCafeLockerPass> studyCafeLockerPasses;

    public StudyCafeLockerPasses(final List<StudyCafeLockerPass> studyCafeLockerPasses) {
        this.studyCafeLockerPasses = studyCafeLockerPasses;
    }

    public Optional<StudyCafeLockerPass> findLockerPassBy(final StudyCafePass pass) {
        return studyCafeLockerPasses.stream()
                .filter(pass::isSameDurationType)
                .findFirst();
    }

}
