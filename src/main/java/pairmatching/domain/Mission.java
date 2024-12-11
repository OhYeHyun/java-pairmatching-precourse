package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    private final String mission;
    private List<Group> crews = new ArrayList<>();

    public Mission(String mission) {
        this.mission = mission;
    }

    public void updateCrews(List<Group> crews) {
        this.crews = crews;
    }

    public String getMission() {
        return mission;
    }

    public boolean existCrews() {
        return !crews.isEmpty();
    }
}
