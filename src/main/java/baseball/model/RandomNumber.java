package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    private final List<Integer> numbers;

    private RandomNumber(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static RandomNumber create() {
        final List<Integer> computer = new ArrayList<>();
        while (computer.size() < BaseballConstants.NUMBER_OF_NUMBERS) {
            final int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new RandomNumber(computer);
    }
}
