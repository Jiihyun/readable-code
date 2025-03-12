package cleancode.studycafe.jiihyun;

import cleancode.studycafe.jiihyun.config.StudyCafeConfig;
import cleancode.studycafe.jiihyun.exception.AppException;
import cleancode.studycafe.jiihyun.io.InputHandler;
import cleancode.studycafe.jiihyun.io.OutputHandler;
import cleancode.studycafe.jiihyun.io.StudyCafeFileHandler;
import cleancode.studycafe.jiihyun.model.StudyCafeLockerPass;
import cleancode.studycafe.jiihyun.model.StudyCafeLockerPasses;
import cleancode.studycafe.jiihyun.model.StudyCafePass;
import cleancode.studycafe.jiihyun.model.StudyCafePassType;
import cleancode.studycafe.jiihyun.model.StudyCafePasses;

public class StudyCafePassMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafeFileHandler studyCafeFileHandler;

    public StudyCafePassMachine(final StudyCafeConfig studyCafeConfig) {
        this.inputHandler = studyCafeConfig.getInputHandler();
        this.outputHandler = studyCafeConfig.getOutputHandler();
        this.studyCafeFileHandler = studyCafeConfig.getStudyCafeFileHandler();
    }

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            StudyCafePasses studyCafePasses = new StudyCafePasses(studyCafeFileHandler.readStudyCafePasses());

            if (doesUserChooseHourly(studyCafePassType)) {
                act(studyCafePasses, StudyCafePassType.HOURLY);
            }
            if (doesUserChooseWeekly(studyCafePassType)) {
                act(studyCafePasses, StudyCafePassType.WEEKLY);
            }
            if (doesUserChooseFixed(studyCafePassType)) {
                act(studyCafePasses, StudyCafePassType.FIXED);
            }
        } catch (AppException e) {
            outputHandler.showExceptionMessage(e);
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private void act(final StudyCafePasses studyCafePasses, final StudyCafePassType studyCafePassType) {
        StudyCafePasses passes = studyCafePasses.getStudyCafePassesByPassType(studyCafePassType);
        outputHandler.showPassListForSelection(passes);
        StudyCafePass selectedPass = inputHandler.getSelectPass(passes);
        if (studyCafePassType == StudyCafePassType.FIXED) {
            checkLockerPass(selectedPass);
            return;
        }
        outputHandler.showPassOrderSummary(selectedPass, null);
    }

    private void checkLockerPass(final StudyCafePass selectedPass) {
        StudyCafeLockerPasses lockerPasses = new StudyCafeLockerPasses(studyCafeFileHandler.readLockerPasses());
        StudyCafeLockerPass lockerPass = lockerPasses.getLockerPassByCafePassTypeAndDuration(selectedPass);

        outputHandler.askLockerPass(lockerPass);
        boolean lockerSelection = inputHandler.getLockerSelection();

        if (lockerSelection) {
            outputHandler.showPassOrderSummary(selectedPass, lockerPass);
            return;
        }
        outputHandler.showPassOrderSummary(selectedPass, null);
    }

    private boolean doesUserChooseHourly(final StudyCafePassType studyCafePassType) {
        return studyCafePassType == StudyCafePassType.HOURLY;
    }

    private boolean doesUserChooseWeekly(final StudyCafePassType studyCafePassType) {
        return studyCafePassType == StudyCafePassType.WEEKLY;
    }

    private boolean doesUserChooseFixed(final StudyCafePassType studyCafePassType) {
        return studyCafePassType == StudyCafePassType.FIXED;
    }

}
