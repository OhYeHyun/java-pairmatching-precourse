package pairmatching.controller;

import pairmatching.service.PairMatching;
import pairmatching.validator.FormatValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.Objects;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PairMatching pairMatching;

    public PairMatchingController(InputView inputView, OutputView outputView, PairMatching pairMatching) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairMatching = pairMatching;
    }

    public void run() {
        boolean quit = false;
        while (!quit) {
            String option = getOption();
            if (Objects.equals(option, "1")) {
                boolean error = true;
                boolean again = false;
                outputView.displayCourse();
                while (error || again) {
                    again = false;
                    try {
                        String[] course = getCourse();
                        if (pairMatching.existCrews(course[0], course[1], course[2])) {
                            String answer = getAnswer();
                            if (Objects.equals(answer, "네")) {
                                pairMatching.generateMatching(course[0], course[1], course[2]);
                                outputView.displayResult(pairMatching.getResentResult());
                            }
                            if (Objects.equals(answer, "아니오")) {
                                again = true;
                            }
                        }
                        if (!pairMatching.existCrews(course[0], course[1], course[2])) {
                            pairMatching.generateMatching(course[0], course[1], course[2]);
                            outputView.displayResult(pairMatching.getResentResult());
                        }
                        error = false;
                    } catch (IllegalArgumentException e) {
                        outputView.lineSpace();
                        outputView.print(e.getMessage());
                    }
                }
            }
            if (Objects.equals(option, "2")) {
                boolean error = true;
                while (error) {
                    try {
                        String[] course = getCourse();
                        if (!pairMatching.existCrews(course[0], course[1], course[2])) {
                            error = false;
                            throw new IllegalArgumentException("[ERROR] 존재하지 않습니다.");
                        }
                        outputView.displayResult(pairMatching.getTargetResult(course[0], course[1], course[2]));
                        error = false;
                    } catch (IllegalArgumentException e) {
                        outputView.lineSpace();
                        outputView.print(e.getMessage());
                    }
                }
            }
            if (Objects.equals(option, "3")) {
                outputView.promptClear();
                pairMatching.clearCrews();
            }
            if (Objects.equals(option, "Q")) {
                quit = true;
            }
        }
    }

    private String getInput() {
        return inputView.getInput();
    }

    private String getOption() {
        while (true) {
            try {
                outputView.promptMenu();
                String option = getInput();
                return FormatValidator.validateOption(option);
            } catch (IllegalArgumentException e) {
                outputView.lineSpace();
                outputView.print(e.getMessage());
            }
        }
    }

    private String getAnswer() {
        while (true) {
            try {
                outputView.promptAnswer();
                String answer = getInput();
                return FormatValidator.validateAnswer(answer);
            } catch (IllegalArgumentException e) {
                outputView.lineSpace();
                outputView.print(e.getMessage());
            }
        }
    }
    private String[] getCourse() {
        while (true) {
            try {
                outputView.promptCourse();
                String course = getInput();
                return FormatValidator.validateCourse(course);
            } catch (IllegalArgumentException e) {
                outputView.lineSpace();
                outputView.print(e.getMessage());
            }
        }
    }
}
