package pairmatching.service;

import pairmatching.domain.CSVReader;
import pairmatching.domain.Course;
import pairmatching.domain.Group;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PairMatching {
    private final GenerateService generateService;
    private final RepositoryService repositoryService;

    private Course backend;
    private Course frontend;

    public PairMatching(GenerateService generateService, RepositoryService repositoryService) {
        this.generateService = generateService;
        this.repositoryService = repositoryService;
        initializeCourse();
        initializeCrews();
    }

    public void initializeCourse() {
        Level level1 = new Level("레벨1", List.of(new Mission("자동차경주"), new Mission("로또"), new Mission("숫자야구게임")));
        Level level2 = new Level("레벨2", List.of(new Mission("장바구니"), new Mission("결제"), new Mission("지하철노선도")));
        Level level3 = new Level("레벨3", List.of());
        Level level4 = new Level("레벨4", List.of(new Mission("성능개선"), new Mission("배포")));
        Level level5 = new Level("레벨5", List.of());

        backend = new Course("백엔드", List.of(level1, level2, level3, level4, level5));
        frontend = new Course("프론트엔드", List.of(level1, level2, level3, level4, level5));
    }

    public void initializeCrews() {
        CSVReader backReader = new CSVReader("src/main/resources/backend-crew.md");
        for (String crew : backReader.getNames()) {
            repositoryService.addBackend(crew);
        }

        CSVReader frontReader = new CSVReader("src/main/resources/frontend-crew.md");
        for (String crew : frontReader.getNames()) {
            repositoryService.addFrontend(crew);
        }
    }

    public void clearCrews() {
        repositoryService.clear();
    }

    public boolean existCrews(String course, String level, String mission) {
        validateCourse(course, level, mission);
        if (Objects.equals(course, "백엔드")) {
            if (backend.findLevel(level).findMission(mission).existCrews()) {
                return true;
            }
        }
        if (Objects.equals(course, "프론트엔드")) {
            if (frontend.findLevel(level).findMission(mission).existCrews()) {
                return true;
            }
        }
        return false;
    }

    public void generateMatching(String course, String level, String mission) {
        if (Objects.equals(course, "백엔드")) {
            generateService.generateBackend(level);
            repositoryService.update(generateService.getGroups(), backend, level, mission);
        }
        if (Objects.equals(course, "프론트엔드")) {
            generateService.generateFrontend(level);
            repositoryService.update(generateService.getGroups(), frontend, level, mission);
        }
    }

    public List<Group> getResult() {
        return generateService.getGroups();
    }

    private boolean existCourse(String course) {
        return Objects.equals(backend.getName(), course) || Objects.equals(frontend.getName(), course);
    }

    private void validateCourse(String course, String level, String mission) {
        try {
            if (!existCourse(course)) {
                System.out.println("1");
                throw new NoSuchElementException();
            }
            if (Objects.equals(course, "백엔드")) {
                backend.findLevel(level).findMission(mission);
            }
            if (Objects.equals(course, "프론트엔드")) {
                frontend.findLevel(level).findMission(mission);
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] : 존재하지 않는 코스입니다.");
        }
    }
}
