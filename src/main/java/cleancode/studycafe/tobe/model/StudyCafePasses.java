package cleancode.studycafe.tobe.model;

import java.util.List;

public class StudyCafePasses {

    private final List<StudyCafePass> studyCafePasses;

    public StudyCafePasses(final List<StudyCafePass> studyCafePasses) {
        this.studyCafePasses = studyCafePasses;
    }


    public List<StudyCafePass> findPassBy(final StudyCafePassType studyCafePassType) {
        return studyCafePasses.stream()
                .filter(studyCafePass -> studyCafePass.isSamePassType(studyCafePassType))
                .toList();
    }

}
