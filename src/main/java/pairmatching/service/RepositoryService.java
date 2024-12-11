package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.CrewByLevelRepository;
import pairmatching.domain.Group;

import java.util.List;

public class RepositoryService {
    private final CrewByLevelRepository crewByLevelRepository;

    public RepositoryService(CrewByLevelRepository crewByLevelRepository) {
        this.crewByLevelRepository = crewByLevelRepository;
    }

    public void update(List<Group> crews, Course course, String level, String mission) {
        for (Group group : crews) {
            crewByLevelRepository.addCrewByLevel(group.getGroup(), level);
        }
        course.findLevel(level).findMission(mission).updateCrews(crews);
    }
}
