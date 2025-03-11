package cleancode.studycafe.jiihyun;

import cleancode.studycafe.jiihyun.config.StudyCafeConfig;
import cleancode.studycafe.jiihyun.io.ConsoleInputHandler;
import cleancode.studycafe.jiihyun.io.ConsoleOutputHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafeConfig studyCafeConfig = new StudyCafeConfig(
                new ConsoleInputHandler(),
                new ConsoleOutputHandler()
        );
        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(studyCafeConfig);
        studyCafePassMachine.run();
    }

}
