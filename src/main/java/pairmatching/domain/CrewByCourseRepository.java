package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrewByCourseRepository {
    private static final CrewByCourseRepository instance = new CrewByCourseRepository();

    private static final List<Crew> backend = new ArrayList<>();
    private static final List<Crew> frontend = new ArrayList<>();

    private CrewByCourseRepository() {}

    public static CrewByCourseRepository getInstance() {
        return instance;
    }

    public void addBackend(Crew crew) {
        backend.add(crew);
    }

    public void addFrontend(Crew crew) {
        frontend.add(crew);
    }

    public void clear() {
        backend.clear();
        frontend.clear();
    }

    public List<Crew> getBackend() {
        return Collections.unmodifiableList(backend);
    }
    public List<Crew> getFrontend() {
        return Collections.unmodifiableList(frontend);
    }
}
