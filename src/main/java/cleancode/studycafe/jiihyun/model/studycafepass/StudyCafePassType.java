package cleancode.studycafe.jiihyun.model.studycafepass;

import cleancode.studycafe.jiihyun.exception.AppException;

import java.util.Arrays;

public enum StudyCafePassType {

    HOURLY("1", "시간 단위 이용권"),
    WEEKLY("2", "주 단위 이용권"),
    FIXED("3", "1인 고정석");

    private final String command;
    private final String description;

    StudyCafePassType(final String command, final String description) {
        this.command = command;
        this.description = description;
    }

    public static StudyCafePassType from(final String userInput) {
        return Arrays.stream(StudyCafePassType.values())
                .filter(studyCafePassType -> studyCafePassType.command.equals(userInput))
                .findAny()
                .orElseThrow(() -> new AppException("잘못된 입력입니다."));
    }

}
