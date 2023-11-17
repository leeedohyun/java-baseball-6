package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.Constants;
import baseball.model.PlayerNumber;
import baseball.model.Referee;
import baseball.model.Validation;
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
            PlayerNumber playerNumber = new PlayerNumber(InputView.inputNumbers());
            referee = Referee.calculateBallAndStrikeNumber(randomNumbers, playerNumber.getPlayerNumber());
            determineResult();
        } while (!referee.isThreeStrike());
    }

    private boolean isRestart() {
        String restartOrEndNumber = InputView.inputNumbers();
        Validation.validateRestartOrEnd(restartOrEndNumber);

        return Constants.GAME_RESTART_NUMBER.equals(restartOrEndNumber);
    }

    private void determineResult() {
        if (referee.isNothing()) {
            OutputView.printNothing();
        }
        if (referee.isOnlyBall()) {
            OutputView.printOnlyBall(referee.getBallNumber());
        }
        if (referee.isOnlyStrike()) {
            OutputView.printOnlyStrike(referee.getStrikeNumber());
        }
        if (referee.isStrikeAndBall()) {
            OutputView.printBallAndStrike(referee.getBallNumber(), referee.getStrikeNumber());
        }
    }
}
