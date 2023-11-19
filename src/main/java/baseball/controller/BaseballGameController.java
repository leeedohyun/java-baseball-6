package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.Constants;
import baseball.model.PlayerNumber;
import baseball.model.Referee;
import baseball.model.InputNumberValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private Referee referee;

    public void play() {
        OutputView.printBaseballGameStartMessage();
        do {
            playSingleBaseballGame();
            OutputView.printAnswerMessage();
            OutputView.printRestartOrEndInputMessage();
        } while (isRestart());
    }

    private void playSingleBaseballGame() {
        final ComputerNumber computerNumber = new ComputerNumber();
        final String randomNumbers = computerNumber.getComputerNumber();

        do {
            OutputView.printMessageToInputNumbers();
            final PlayerNumber playerNumber = new PlayerNumber(InputView.inputNumbers());
            referee = Referee.calculateBallAndStrikeNumber(randomNumbers, playerNumber.getPlayerNumber());
            determineResult();
        } while (!referee.isThreeStrike());
    }

    private boolean isRestart() {
        final String restartOrEndNumber = InputView.inputNumbers();
        InputNumberValidator.validateRestartOrEnd(restartOrEndNumber);

        return Constants.GAME_RESTART_NUMBER.equals(restartOrEndNumber);
    }

    private void determineResult() {
        if (referee.isNothing()) {
            OutputView.printNothing();
            return;
        }
        if (referee.isOnlyBall()) {
            OutputView.printOnlyBall(referee.getBallNumber());
            return;
        }
        if (referee.isOnlyStrike()) {
            OutputView.printOnlyStrike(referee.getStrikeNumber());
            return;
        }
        if (referee.isStrikeAndBall()) {
            OutputView.printBallAndStrike(referee.getBallNumber(), referee.getStrikeNumber());
        }
    }
}
