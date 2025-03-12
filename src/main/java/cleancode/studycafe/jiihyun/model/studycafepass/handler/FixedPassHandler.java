package cleancode.studycafe.jiihyun.model.studycafepass.handler;

import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePassType;
import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePasses;

public class FixedPassHandler implements StudyCafePassHandler {

    @Override
    public boolean isAppliable(final StudyCafePassType studyCafePassType) {
        return studyCafePassType == StudyCafePassType.FIXED;
    }

    @Override
    public StudyCafePasses findCandidateStudyCafePasses(final StudyCafePasses studyCafePasses) {
        return studyCafePasses.getStudyCafePassesByPassType(StudyCafePassType.FIXED);

    }

}
