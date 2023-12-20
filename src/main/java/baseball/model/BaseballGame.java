package baseball.model;

import java.util.stream.IntStream;

public class BaseballGame {

    private final InputNumber inputNumber;
    private final RandomNumber randomNumber;

    public BaseballGame(final InputNumber inputNumber, final RandomNumber randomNumber) {
        this.inputNumber = inputNumber;
        this.randomNumber = randomNumber;
    }

    public int countStrike() {
        return (int) IntStream.range(0, BaseballConstants.NUMBER_OF_NUMBERS)
                .filter(this::isStrike)
                .count();
    }

    public int countBall() {
        return (int) IntStream.range(0, BaseballConstants.NUMBER_OF_NUMBERS)
                .filter(i -> !isStrike(i) && randomNumber.hasNumber(inputNumber.getInputNumberByIndex(i)))
                .count();
    }

    private boolean isStrike(final int index) {
        return randomNumber.getRandomNumberByIndex(index) == inputNumber.getInputNumberByIndex(index);
    }
}
