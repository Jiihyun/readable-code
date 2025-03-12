package cleancode.studycafe.jiihyun.io;

import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePass;
import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePassType;
import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePasses;

public interface InputHandler {

    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(StudyCafePasses passes);

    boolean getLockerSelection();

}
