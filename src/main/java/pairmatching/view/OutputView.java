package pairmatching.view;

import pairmatching.domain.Crew;
import pairmatching.domain.Group;

import java.util.List;

public class OutputView {

    public void print(String text) {
        System.out.println(text);
    }

    public void lineSpace() {
        System.out.print(System.lineSeparator());
    }

    public void promptMenu() {
        lineSpace();
        print("기능을 선택하세요.");
        print("1. 페어 매칭");
        print("2. 페어 조회");
        print("3. 페어 초기화");
        print("Q. 종료");
    }

    public void promptClear() {
        lineSpace();
        print("초기화 되었습니다.");
    }

    public void displayCourse() {
        lineSpace();
        print("#############################################");
        print("과정: 백엔드 | 프론트엔드");
        print("미션:");
        print("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        print("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
        print("  - 레벨3: ");
        print("  - 레벨4: 성능개선 | 배포");
        print("  - 레벨5: ");
        print("############################################");
    }

    public void promptCourse() {
        lineSpace();
        print("과정, 레벨, 미션을 선택하세요.");
        print("ex) 백엔드, 레벨1, 자동차경주");
    }

    public void promptAnswer() {
        lineSpace();
        print("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        print("네 | 아니오");
    }

    public void displayResult(List<Group> crews) {
        lineSpace();
        print("페어 매칭 결과입니다.");
        for (Group group : crews) {
            print(String.join(" : ", group.getGroup().stream().map(Crew::getName).toArray(String[]::new)));
        }
    }
}
