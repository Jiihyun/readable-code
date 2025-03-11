package cleancode.studycafe.jiihyun.config;

import cleancode.studycafe.jiihyun.io.InputHandler;
import cleancode.studycafe.jiihyun.io.OutputHandler;

public class StudyCafeConfig {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public StudyCafeConfig(final InputHandler inputHandler, final OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }
}
