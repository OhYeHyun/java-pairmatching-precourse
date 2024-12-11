package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MatchingGenerator {

    public static List<Crew> generate(List<Crew> crews) {
        return Randoms.shuffle(crews);
    }
}
