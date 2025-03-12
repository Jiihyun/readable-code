package cleancode.studycafe.jiihyun.model.studycafepass;

import cleancode.studycafe.jiihyun.exception.AppException;
import cleancode.studycafe.jiihyun.model.studycafepass.handler.FixedPassHandler;
import cleancode.studycafe.jiihyun.model.studycafepass.handler.HourlyPassHandler;
import cleancode.studycafe.jiihyun.model.studycafepass.handler.StudyCafePassHandler;
import cleancode.studycafe.jiihyun.model.studycafepass.handler.WeeklyPassHandler;

import java.util.List;

public class StudyCafePassProcessor {

    private final List<StudyCafePassHandler> handlers = initializeHandlers();

    public StudyCafePasses filterPassesByType(final StudyCafePassType studyCafePassType, final StudyCafePasses studyCafePasses) {
        final StudyCafePassHandler studyCafePassHandler = getApplicableHandler(studyCafePassType);
        return studyCafePassHandler.findCandidateStudyCafePasses(studyCafePasses);
    }

    private StudyCafePassHandler getApplicableHandler(final StudyCafePassType studyCafePassType) {
        return handlers.stream()
                .filter(handler -> handler.isAppliable(studyCafePassType))
                .findAny()
                .orElseThrow(() -> new AppException("해당 이용권에 맞는 핸들러가 없습니다."));
    }

    private List<StudyCafePassHandler> initializeHandlers() {
        return List.of(
                new HourlyPassHandler(),
                new WeeklyPassHandler(),
                new FixedPassHandler()
        );
    }

}
