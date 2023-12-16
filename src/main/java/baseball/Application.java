package baseball;

import baseball.controller.BaseballController;
import baseball.model.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new BaseballController(new BaseballGame(), new InputView(), new OutputView()).play();
    }
}
