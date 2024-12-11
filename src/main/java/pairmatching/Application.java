package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.CrewByCourseRepository;
import pairmatching.domain.CrewByLevelRepository;
import pairmatching.service.GenerateService;
import pairmatching.service.PairMatching;
import pairmatching.service.RepositoryService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CrewByCourseRepository crewByCourseRepository = CrewByCourseRepository.getInstance();
        CrewByLevelRepository crewByLevelRepository = CrewByLevelRepository.getInstance();

        GenerateService generateService = new GenerateService(crewByCourseRepository, crewByLevelRepository);
        RepositoryService repositoryService = new RepositoryService(crewByCourseRepository, crewByLevelRepository);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        PairMatching pairMatching = new PairMatching(generateService, repositoryService);

        PairMatchingController controller = new PairMatchingController(inputView, outputView, pairMatching);
        controller.run();
    }
}
