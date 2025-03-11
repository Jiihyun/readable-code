package cleancode.studycafe.jiihyun.io;

import cleancode.studycafe.jiihyun.model.StudyCafePass;
import cleancode.studycafe.jiihyun.model.StudyCafePassType;

import java.util.List;

public interface InputHandler {

    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(List<StudyCafePass> passes);

    boolean getLockerSelection();

}
