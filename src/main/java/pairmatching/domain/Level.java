package pairmatching.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Level {
    private final String name;
    private final List<Mission> missions;

    public Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public Mission findMission(String name) {
        return missions.stream()
                .filter(mission -> Objects.equals(mission.getName(), name))
                .findAny()
                .get();
    }

    public String getName() {
        return name;
    }

    public List<Mission> getMissions() {
        return Collections.unmodifiableList(missions);
    }
}
