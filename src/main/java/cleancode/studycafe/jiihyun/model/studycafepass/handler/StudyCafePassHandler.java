package cleancode.studycafe.jiihyun.model.studycafepass.handler;

import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePassType;
import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePasses;

public interface StudyCafePassHandler {

    boolean isAppliable(final StudyCafePassType studyCafePassType);

    StudyCafePasses findCandidateStudyCafePasses(final StudyCafePasses studyCafePasses);

}
