package baseball.model;

import java.util.stream.IntStream;

public class Referee {

    private final int strikeNumber;
    private final int ballNumber;

    private Referee(final int strikeNumber, final int ballNumber) {
        this.strikeNumber = strikeNumber;
        this.ballNumber = ballNumber;
    }

    public static Referee calculateBallAndStrikeNumber(final ComputerNumber computerNumber,
                                                       final PlayerNumber playerNumber) {
        return new Referee(calculateStrikeNumbers(computerNumber, playerNumber),
                calculateBallNumbers(computerNumber, playerNumber));
    }

    public boolean isNothing() {
        return strikeNumber == Constants.ZERO && ballNumber == Constants.ZERO;
    }

    public boolean isOnlyBall() {
        return strikeNumber == Constants.ZERO && ballNumber != Constants.ZERO;
    }

    public boolean isOnlyStrike() {
        return strikeNumber != Constants.ZERO && ballNumber == Constants.ZERO;
    }

    public boolean isStrikeAndBall() {
        return strikeNumber != Constants.ZERO && ballNumber != Constants.ZERO;
    }

    public boolean isThreeStrike() {
        return strikeNumber == Constants.THREE_STRIKE;
    }

    public int getStrikeNumber() {
        return strikeNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    private static int calculateStrikeNumbers(final ComputerNumber computerNumber, final PlayerNumber playerNumber) {
        return (int) IntStream.range(Constants.ZERO, Constants.NUMBER_OF_NUMBERS)
                .filter(index -> isSameNumberInSamePlace(computerNumber.getOneNumberByIndex(index),
                        playerNumber.getOneNumberByIndex(index)))
                .count();
    }

    private static int calculateBallNumbers(final ComputerNumber computerNumber, final PlayerNumber playerNumber) {
        return (int) IntStream.range(Constants.ZERO, Constants.NUMBER_OF_NUMBERS)
                .filter(inputNumbersIndex ->
                        computerNumber.hasInputNumber(playerNumber.getOneNumberByIndex(inputNumbersIndex)))
                .filter(index -> !isSameNumberInSamePlace(computerNumber.getOneNumberByIndex(index),
                        playerNumber.getOneNumberByIndex(index)))
                .count();
    }

    private static boolean isSameNumberInSamePlace(final char randomNumber, final char inputNumber) {
        return randomNumber == inputNumber;
    }
}
