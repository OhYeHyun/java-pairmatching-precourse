package pairmatching.service;

import pairmatching.domain.CrewByLevelRepository;
import pairmatching.domain.Group;

import java.util.List;

public class RepositoryService {
    private final CrewByLevelRepository crewByLevelRepository;

    public RepositoryService(CrewByLevelRepository crewByLevelRepository) {
        this.crewByLevelRepository = crewByLevelRepository;
    }

    public void update(List<Group> crews, String level) {
        for (Group group : crews) {
            crewByLevelRepository.addCrewByLevel(group.getGroup(), level);
        }
    }
}
