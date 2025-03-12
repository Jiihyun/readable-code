package cleancode.studycafe.jiihyun.io;

import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePass;
import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePassType;
import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePasses;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public StudyCafePassType getPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();
        return StudyCafePassType.from(userInput);
    }

    @Override
    public StudyCafePass getSelectPass(StudyCafePasses passes) {
        String userInput = SCANNER.nextLine();
        int selectedIndex = Integer.parseInt(userInput) - 1;
        return passes.getStudyCafePass(selectedIndex);
    }

    @Override
    public boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return "1".equals(userInput);
    }

}

