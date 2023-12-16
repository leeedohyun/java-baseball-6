package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

public class BaseballGame {

    public int countStrike(final List<Integer> inputNumber, final List<Integer> randomNumber) {
        return (int) IntStream.range(0, BaseballConstants.NUMBER_OF_NUMBERS)
                .filter(i -> randomNumber.get(i).equals(inputNumber.get(i)))
                .count();
    }

    public int countBall(final List<Integer> inputNumber, final List<Integer> randomNumber) {
        return (int) IntStream.range(0, BaseballConstants.NUMBER_OF_NUMBERS)
                .filter(i -> !inputNumber.get(i).equals(randomNumber.get(i))
                        && randomNumber.contains(inputNumber.get(i)))
                .count();
    }

    public boolean isNothing(final int strikeNumber, final int ballNumber) {
        return strikeNumber == 0 && ballNumber == 0;
    }
}
