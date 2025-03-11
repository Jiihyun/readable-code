package cleancode.studycafe.jiihyun.io;

import cleancode.studycafe.jiihyun.model.StudyCafeLockerPass;
import cleancode.studycafe.jiihyun.model.StudyCafePass;
import cleancode.studycafe.jiihyun.model.StudyCafePassType;

//Question: 도메인을 반환해도 될지?
public class FileLineParser {

    private static final String SPLITTER = ",";

    private FileLineParser() {
    }

    public static StudyCafePass parsePassList(final String line) {
        final String[] values = line.split(SPLITTER);

        final StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        final int duration = Integer.parseInt(values[1]);
        final int price = Integer.parseInt(values[2]);
        final double discountRate = Double.parseDouble(values[3]);

        return StudyCafePass.of(studyCafePassType, duration, price, discountRate);
    }

    public static StudyCafeLockerPass parseLocker(final String line) {
        final String[] values = line.split(SPLITTER);

        final StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        final int duration = Integer.parseInt(values[1]);
        final int price = Integer.parseInt(values[2]);

        return StudyCafeLockerPass.of(studyCafePassType, duration, price);
    }
}
