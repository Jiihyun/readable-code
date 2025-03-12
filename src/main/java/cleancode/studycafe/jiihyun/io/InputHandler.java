package cleancode.studycafe.jiihyun.io;

import cleancode.studycafe.jiihyun.model.StudyCafePass;
import cleancode.studycafe.jiihyun.model.StudyCafePassType;
import cleancode.studycafe.jiihyun.model.StudyCafePasses;

import java.util.List;

public interface InputHandler {

    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(StudyCafePasses passes);

    boolean getLockerSelection();

}
