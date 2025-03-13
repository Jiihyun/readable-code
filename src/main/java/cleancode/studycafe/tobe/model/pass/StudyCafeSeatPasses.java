package cleancode.studycafe.tobe.model.pass;

import java.util.List;

public class StudyCafeSeatPasses {

    private final List<StudyCafeSeatPass> studyCafeSeatPasses;

    public StudyCafeSeatPasses(final List<StudyCafeSeatPass> studyCafeSeatPasses) {
        this.studyCafeSeatPasses = studyCafeSeatPasses;
    }


    public List<StudyCafeSeatPass> findPassBy(final StudyCafePassType studyCafePassType) {
        return studyCafeSeatPasses.stream()
                .filter(studyCafePass -> studyCafePass.isSamePassType(studyCafePassType))
                .toList();
    }

}
