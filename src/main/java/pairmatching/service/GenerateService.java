package pairmatching.service;

import pairmatching.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GenerateService {
    private final CrewByCourseRepository crewByCourseRepository;
    private final CrewByLevelRepository crewByLevelRepository;
    private List<Crew> newCrews = new ArrayList<>();

    public GenerateService(CrewByCourseRepository crewByCourseRepository, CrewByLevelRepository crewByLevelRepository) {
        this.crewByCourseRepository = crewByCourseRepository;
        this.crewByLevelRepository = crewByLevelRepository;
    }

    public void generateBackend(String level) {
        int tryCount = 0;
        Map<Crew, List<Crew>> crewByLevel = crewByLevelRepository.getLevel(level);

        List<Crew> tempCrews = new ArrayList<>();
        boolean duplication = true;
        while (duplication) {
            tempCrews = MatchingGenerator.generate(crewByCourseRepository.getBackend());
            List<Group> newGroups = createGroups(tempCrews);
            duplication = isDuplicate(crewByLevel, newGroups);

            tryCount++;
            if (tryCount == 3) {
                throw new IllegalArgumentException("[ERROR] 매칭할 수  없습니다.");
            }
        }
        newCrews = tempCrews;
    }

    public void generateFrontend(String level) {
        int tryCount = 0;
        Map<Crew, List<Crew>> crewByLevel = crewByLevelRepository.getLevel(level);

        List<Crew> tempCrews = new ArrayList<>();
        boolean duplication = true;
        while (duplication) {
            tempCrews = MatchingGenerator.generate(crewByCourseRepository.getFrontend());
            List<Group> newGroups = createGroups(tempCrews);
            duplication = isDuplicate(crewByLevel, newGroups);

            tryCount++;
            if (tryCount == 3) {
                throw new IllegalArgumentException("[ERROR] 매칭할 수  없습니다.");
            }
        }
        newCrews = tempCrews;
    }

    private boolean isDuplicate(Map<Crew, List<Crew>> crewByLevel, List<Group> newGroups) {
        for (Group group : newGroups) {
            for (Crew crew : group.getGroup()) {
                List<Crew> newOthers = group.getGroup().stream().filter(crews -> !Objects.equals(crew, crews)).toList();
                List<Crew> others = crewByLevel.get(crew);

                int targetSize = newOthers.size() + others.size();
                int size = (int) List.of(others.addAll(newOthers)).stream().distinct().count();

                if (targetSize != size) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<Group> createGroups(List<Crew> crews) {
        List<Group> newGroups = new ArrayList<>();

        for (int i = 0; i < crews.size(); i++) {
            if (i % 2 == 0) {
                if (crews.size() - i == 3) {
                    newGroups.add(new Group(crews.subList(i, i + 2)));
                    break;
                }
                if (crews.size() - i != 3) {
                    newGroups.add(new Group(crews.subList(i, i + 1)));
                }
            }
        }
        return newGroups;
    }

    public void generateFrontend() {
        newCrews = MatchingGenerator.generate(crewByCourseRepository.getFrontend());
    }

    public List<Crew> getNewCrews() {
        return Collections.unmodifiableList(newCrews);
    }
}
