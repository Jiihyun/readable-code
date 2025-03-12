package cleancode.studycafe.jiihyun.io;

import cleancode.studycafe.jiihyun.model.lockerpass.StudyCafeLockerPass;
import cleancode.studycafe.jiihyun.model.studycafepass.StudyCafePass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StudyCafeFileHandler {

    private static final String PATH_OF_PASS_LIST = "src/main/resources/cleancode/studycafe/pass-list.csv";
    private static final String PATH_OF_LOCKER = "src/main/resources/cleancode/studycafe/locker.csv";

    public List<StudyCafePass> readStudyCafePasses() {
        try {
            final List<String> lines = Files.readAllLines(Paths.get(PATH_OF_PASS_LIST));
            return getStudyCafePasses(lines);
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    private List<StudyCafePass> getStudyCafePasses(final List<String> lines) {
        return lines.stream()
                .map(FileLineParser::parsePassList)
                .toList();
    }

    public List<StudyCafeLockerPass> readLockerPasses() {
        try {
            final List<String> lines = Files.readAllLines(Paths.get(PATH_OF_LOCKER));
            return getStudyCafeLockerPass(lines);
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    private List<StudyCafeLockerPass> getStudyCafeLockerPass(final List<String> lines) {
        return lines.stream()
                .map(FileLineParser::parseLocker)
                .toList();
    }

}
