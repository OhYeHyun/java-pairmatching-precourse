package pairmatching.domain;

import java.util.*;

public class CrewByLevelRepository {
    private static final CrewByLevelRepository instance = new CrewByLevelRepository();

    private static final Map<Crew, List<Crew>> level1 = new HashMap<>();
    private static final Map<Crew, List<Crew>> level2 = new HashMap<>();
    private static final Map<Crew, List<Crew>> level3 = new HashMap<>();
    private static final Map<Crew, List<Crew>> level4 = new HashMap<>();
    private static final Map<Crew, List<Crew>> level5 = new HashMap<>();

    private CrewByLevelRepository() {}

    public static CrewByLevelRepository getInstance() {
        return instance;
    }

    public void clear() {
        level1.clear();
        level2.clear();
        level3.clear();
        level4.clear();
        level5.clear();
    }

    public void addCrewByLevel(List<Crew> group, String level) {
        if (Objects.equals(level, "레벨1")) {
            addLevel(level1, group);
        }
        if (Objects.equals(level, "레벨2")) {
            addLevel(level2, group);
        }
        if (Objects.equals(level, "레벨3")) {
            addLevel(level3, group);
        }
        if (Objects.equals(level, "레벨4")) {
            addLevel(level4, group);
        }
        if (Objects.equals(level, "레벨5")) {
            addLevel(level5, group);
        }
    }

    private void addLevel(Map<Crew, List<Crew>> level, List<Crew> group) {
        for (Crew crew : group) {
            List<Crew> others = group.stream().filter(crews -> !Objects.equals(crew, crews)).toList();
            putList(level, crew, others);
        }
    }

    private void putList(Map<Crew, List<Crew>> level, Crew crew, List<Crew> others) {
        if (level.containsKey(crew)) {
            level.get(crew).addAll(others);
        }
        if (!level.containsKey(crew)) {
            level.put(crew, others);
        }
    }

    public Map<Crew, List<Crew>> getLevel(String level) {
        if (Objects.equals(level, "레벨1")) {
            return Collections.unmodifiableMap(level1);
        }
        if (Objects.equals(level, "레벨2")) {
            return Collections.unmodifiableMap(level2);
        }
        if (Objects.equals(level, "레벨3")) {
            return Collections.unmodifiableMap(level3);
        }
        if (Objects.equals(level, "레벨4")) {
            return Collections.unmodifiableMap(level4);
        }
        return Collections.unmodifiableMap(level5);
    }
}
