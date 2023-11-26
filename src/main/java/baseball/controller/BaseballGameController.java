package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.Constants;
import baseball.model.InputNumberValidator;
import baseball.model.PlayerNumber;
import baseball.model.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private Referee referee;

    public BaseballGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printBaseballGameStartMessage();
        do {
            playSingleBaseballGame();
            outputView.printAnswerMessage();
            outputView.printRestartOrEndInputMessage();
        } while (isRestart());
    }

    private void playSingleBaseballGame() {
        final ComputerNumber computerNumber = new ComputerNumber();
        final String randomNumbers = computerNumber.getComputerNumber();

        do {
            outputView.printMessageToInputNumbers();
            final PlayerNumber playerNumber = new PlayerNumber(inputView.inputNumbers());
            referee = Referee.calculateBallAndStrikeNumber(randomNumbers, playerNumber.getPlayerNumber());
            determineResult();
        } while (!referee.isThreeStrike());
    }

    private boolean isRestart() {
        final String restartOrEndNumber = inputView.inputNumbers();
        InputNumberValidator.validateRestartOrEnd(restartOrEndNumber);

        return Constants.GAME_RESTART_NUMBER.equals(restartOrEndNumber);
    }

    private void determineResult() {
        if (referee.isNothing()) {
            outputView.printNothing();
            return;
        }
        if (referee.isOnlyBall()) {
            outputView.printOnlyBall(referee.getBallNumber());
            return;
        }
        if (referee.isOnlyStrike()) {
            outputView.printOnlyStrike(referee.getStrikeNumber());
            return;
        }
        if (referee.isStrikeAndBall()) {
            outputView.printBallAndStrike(referee.getBallNumber(), referee.getStrikeNumber());
        }
    }
}
