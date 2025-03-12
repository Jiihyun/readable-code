package cleancode.studycafe.jiihyun.config;

import cleancode.studycafe.jiihyun.io.InputHandler;
import cleancode.studycafe.jiihyun.io.OutputHandler;
import cleancode.studycafe.jiihyun.io.StudyCafeFileHandler;

public class StudyCafeConfig {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafeFileHandler studyCafeFileHandler;

    public StudyCafeConfig(final InputHandler inputHandler, final OutputHandler outputHandler, final StudyCafeFileHandler studyCafeFileHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.studyCafeFileHandler = studyCafeFileHandler;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }

    public StudyCafeFileHandler getStudyCafeFileHandler() {
        return studyCafeFileHandler;
    }
}
