package cleancode.studycafe.jiihyun.model.studycafepass;

import java.util.List;

public class StudyCafePasses {

    private final List<StudyCafePass> studyCafePasses;

    public StudyCafePasses(final List<StudyCafePass> studyCafePasses) {
        this.studyCafePasses = studyCafePasses;
    }

    public StudyCafePasses getStudyCafePassesByPassType(final StudyCafePassType studyCafePassType) {
        final List<StudyCafePass> passesByPassType = studyCafePasses.stream()
                .filter(studyCafePass -> studyCafePass.isSamePassTypeWith(studyCafePassType))
                .toList();
        return new StudyCafePasses(passesByPassType);
    }

    public StudyCafePass getStudyCafePass(int index) {
        return studyCafePasses.get(index);
    }

    public int getSize() {
        return studyCafePasses.size();
    }
}
