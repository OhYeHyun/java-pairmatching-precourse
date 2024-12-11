package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewByCourseRepository;
import pairmatching.domain.CrewByLevelRepository;
import pairmatching.domain.Group;

import java.util.List;

public class RepositoryService {
    private final CrewByCourseRepository crewByCourseRepository;
    private final CrewByLevelRepository crewByLevelRepository;

    public RepositoryService(CrewByCourseRepository crewByCourseRepository, CrewByLevelRepository crewByLevelRepository) {
        this.crewByCourseRepository = crewByCourseRepository;
        this.crewByLevelRepository = crewByLevelRepository;
    }

    public void addBackend(String name) {
        crewByCourseRepository.addBackend(new Crew(name, "백엔드"));
    }

    public void addFrontend(String name) {
        crewByCourseRepository.addFrontend(new Crew(name, "프론트엔드"));
    }

    public void clear() {
        crewByLevelRepository.clear();
    }

    public void update(List<Group> crews, Course course, String level, String mission) {
        for (Group group : crews) {
            crewByLevelRepository.addCrewByLevel(group.getGroup(), level);
        }
        course.findLevel(level).findMission(mission).updateCrews(crews);
    }
}
