package pairmatching.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Course {
    private final String name;
    private final List<Level> levels;

    public Course(String name, List<Level> levels) {
        this.name = name;
        this.levels = levels;
    }

    public Level findLevel(String name) {
        return levels.stream()
                .filter(level -> Objects.equals(level.getName(), name))
                .findAny()
                .get();
    }

    public String getName() {
        return name;
    }

    public List<Level> getLevels() {
        return Collections.unmodifiableList(levels);
    }
}
