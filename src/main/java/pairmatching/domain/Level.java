package pairmatching.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Level {
    private final Map<String, List<String>> levels = new LinkedHashMap<>();

    public Level(String level, List<String> missions) {
        createLevelInfo(level, missions);
    }

    private void createLevelInfo(String level, List<String> missions) {
        levels.put(level, missions);
    }

    public List<String> getMissions(String level) {
        return levels.get(level);
    }
}
