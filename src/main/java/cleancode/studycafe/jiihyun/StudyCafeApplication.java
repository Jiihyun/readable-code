package cleancode.studycafe.jiihyun;

import cleancode.studycafe.jiihyun.config.StudyCafeConfig;
import cleancode.studycafe.jiihyun.io.ConsoleInputHandler;
import cleancode.studycafe.jiihyun.io.ConsoleOutputHandler;
import cleancode.studycafe.jiihyun.io.StudyCafeFileHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafeConfig studyCafeConfig = new StudyCafeConfig(
                new ConsoleInputHandler(),
                new ConsoleOutputHandler(),
                new StudyCafeFileHandler()
        );
        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(studyCafeConfig);
        studyCafePassMachine.run();
    }

}
