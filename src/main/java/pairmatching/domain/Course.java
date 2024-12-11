package pairmatching.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private final String course;
    private final Map<String, List<String>> levelInfo = new LinkedHashMap<>();

    public Course(String course, String level, List<String> missions) {
        this.course = course;
        createLevelInfo(level, missions);
    }

    private void createLevelInfo(String level, List<String> missions) {
        levelInfo.put(level, missions);
    }

    public String getCourse() {
        return course;
    }

    public List<String> getMissions(String level) {
        return levelInfo.get(level);
    }
}
