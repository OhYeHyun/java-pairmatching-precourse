package pairmatching.validator;

import java.util.Arrays;
import java.util.Objects;

public class FormatValidator {
    private static final String DELIMITER = ",";

    public static String validateOption(String option) {
        if (!Objects.equals(option, "1") && !Objects.equals(option, "2") && !Objects.equals(option, "3") && !Objects.equals(option, "Q")) {
            throw new IllegalArgumentException("[ERROR] 사용할 수 없는 기능입니다.");
        }
        return option;
    }

    public static String[] validateCourse(String course) {
        String[] parts = course.trim().split(DELIMITER, -1);
        if (parts.length != 3) {
            throw new IllegalArgumentException("[ERROR] 형식이 잘못 입력되었습니다.");
        }
        return parts;
    }

    public static String validateAnswer(String answer) {
        if (!Objects.equals(answer, "네") || !Objects.equals(answer, "아니오")) {
            throw new IllegalArgumentException("[ERROR] 네, 아니오로 입력해 주세요.");
        }
        return answer;
    }
}
