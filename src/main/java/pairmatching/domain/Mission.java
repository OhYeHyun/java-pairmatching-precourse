package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    private final String name;
    private List<Group> crews = new ArrayList<>();

    public Mission(String name) {
        this.name = name;
    }

    public void updateCrews(List<Group> crews) {
        this.crews = crews;
    }

    public boolean existCrews() {
        return !crews.isEmpty();
    }

    public String getName() {
        return name;
    }
}
