package cleancode.studycafe.jiihyun;

import cleancode.studycafe.jiihyun.config.StudyCafeConfig;
import cleancode.studycafe.jiihyun.exception.AppException;
import cleancode.studycafe.jiihyun.io.InputHandler;
import cleancode.studycafe.jiihyun.io.OutputHandler;
import cleancode.studycafe.jiihyun.io.StudyCafeFileHandler;
import cleancode.studycafe.jiihyun.model.lockerpass.StudyCafeLockerPass;
import cleancode.studycafe.jiihyun.model.lockerpass.StudyCafeLockerPasses;
import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePass;
import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePassProcessor;
import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePassType;
import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePasses;

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
            final StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();
            processUserSelection(studyCafePassType);
        } catch (AppException e) {
            outputHandler.showExceptionMessage(e);
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private void processUserSelection(final StudyCafePassType studyCafePassType) {
        final StudyCafePasses availablePasses = getAvailablePasses(studyCafePassType);

        outputHandler.showPassListForSelection(availablePasses);
        final StudyCafePass selectedPass = inputHandler.getSelectPass(availablePasses);
        if (studyCafePassType == StudyCafePassType.FIXED) {
            checkLockerPass(selectedPass);
            return;
        }
        outputHandler.showPassOrderSummary(selectedPass, null);
    }

    private StudyCafePasses getAvailablePasses(final StudyCafePassType studyCafePassType) {
        final StudyCafePasses allPasses = new StudyCafePasses(studyCafeFileHandler.readStudyCafePasses());
        final StudyCafePassProcessor studyCafePassProcessor = new StudyCafePassProcessor();
        return studyCafePassProcessor.filterPassesByType(studyCafePassType, allPasses);
    }

    private void checkLockerPass(final StudyCafePass selectedPass) {
        final StudyCafeLockerPasses lockerPasses = new StudyCafeLockerPasses(studyCafeFileHandler.readLockerPasses());
        final StudyCafeLockerPass lockerPass = lockerPasses.getLockerPassByCafePassTypeAndDuration(selectedPass);

        outputHandler.askLockerPass(lockerPass);
        final boolean lockerSelection = inputHandler.getLockerSelection();

        if (lockerSelection) {
            outputHandler.showPassOrderSummary(selectedPass, lockerPass);
            return;
        }
        outputHandler.showPassOrderSummary(selectedPass, null);
    }

}
