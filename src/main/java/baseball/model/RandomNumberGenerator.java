package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    public static List<Integer> generate() {
        final List<Integer> computer = new ArrayList<>();
        while (computer.size() < BaseballConstants.NUMBER_OF_NUMBERS) {
            final int randomNumber = Randoms.pickNumberInRange(BaseballConstants.MIN_RANGE,
                    BaseballConstants.MAX_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
