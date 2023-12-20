package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.InputNumber;
import baseball.model.RandomNumber;
import baseball.model.RandomNumberGenerator;
import baseball.model.RetryOrEnd;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private static final int THREE_STRIKE = 3;

    private final BaseballGame baseballGame;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(final BaseballGame baseballGame, final InputView inputView, final OutputView outputView) {
        this.baseballGame = baseballGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printStartMessage();

        while (true) {
            final RandomNumber randomNumber = RandomNumber.create(new RandomNumberGenerator());
            if (!playOne(randomNumber)) {
                break;
            }
        }
    }

    private boolean playOne(final RandomNumber randomNumber) {
        while (true) {
            final InputNumber inputNumber = InputNumber.create(inputView.inputNumber());
            final int strike = baseballGame.countStrike(inputNumber, randomNumber);
            final int ball = baseballGame.countBall(inputNumber, randomNumber);

            outputView.printResult(strike, ball);

            if (strike == THREE_STRIKE) {
                outputView.printThreeStrike(strike);
                return RetryOrEnd.canRetry(inputView.inputCommand());
            }
        }
    }
}
