package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
    private final String course;
    private final List<Level> levels;

    public Course(String course, List<Level> levels) {
        this.course = course;
        this.levels = levels;
    }

    public String getCourse() {
        return course;
    }

    public List<Level> getLevels() {
        return Collections.unmodifiableList(levels);
    }
}
