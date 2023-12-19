package baseball.model;

import java.util.stream.IntStream;

public class BaseballGame {

    public int countStrike(final InputNumber inputNumber, final RandomNumber randomNumber) {
        return (int) IntStream.range(0, BaseballConstants.NUMBER_OF_NUMBERS)
                .filter(i -> randomNumber.getRandomNumberByIndex(i) == inputNumber.getInputNumberByIndex(i))
                .count();
    }

    public int countBall(final InputNumber inputNumber, final RandomNumber randomNumber) {
        return (int) IntStream.range(0, BaseballConstants.NUMBER_OF_NUMBERS)
                .filter(i -> inputNumber.getInputNumberByIndex(i) != randomNumber.getRandomNumberByIndex(i)
                        && randomNumber.hasNumber(inputNumber.getInputNumberByIndex(i)))
                .count();
    }

    public boolean isNothing(final int strikeNumber, final int ballNumber) {
        return strikeNumber == 0 && ballNumber == 0;
    }
}
