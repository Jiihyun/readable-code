package cleancode.studycafe.jiihyun.io;

import cleancode.studycafe.jiihyun.exception.AppException;
import cleancode.studycafe.jiihyun.model.StudyCafeLockerPass;
import cleancode.studycafe.jiihyun.model.StudyCafePass;
import cleancode.studycafe.jiihyun.model.StudyCafePasses;

import java.util.List;

public interface OutputHandler {

    void showWelcomeMessage();

    void showAnnouncement();

    void askPassTypeSelection();

    void showPassListForSelection(StudyCafePasses passes);

    void askLockerPass(StudyCafeLockerPass lockerPass);

    void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass);

    void showSimpleMessage(String message);

    void showExceptionMessage(AppException exception);

}
