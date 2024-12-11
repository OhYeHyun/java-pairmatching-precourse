package pairmatching.domain;

import java.util.List;

public class Group {
    private final List<Crew> group;

    public Group(List<Crew> group) {
        this.group = group;
    }

    public List<Crew> getGroup() {
        return group;
    }
}
