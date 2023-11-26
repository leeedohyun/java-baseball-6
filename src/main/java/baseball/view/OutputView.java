package baseball.view;

public class OutputView {

    private static final String BASEBALL_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUTTING_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String BLANK_SPACE = " ";
    public static final String RESTART_OR_END_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printBaseballGameStartMessage() {
        System.out.println(BASEBALL_GAME_START_MESSAGE);
    }

    public void printMessageToInputNumbers() {
        System.out.print(INPUTTING_NUMBERS_MESSAGE);
    }

    public void printNothing() {
        System.out.println(NOTHING);
    }

    public void printOnlyStrike(final int strikeNumbers) {
        System.out.println(strikeNumbers + STRIKE);
    }

    public void printOnlyBall(final int ballNumbers) {
        System.out.println(ballNumbers + BALL);
    }

    public void printBallAndStrike(final int ballNumbers, final int strikeNumbers) {
        System.out.println(ballNumbers + BALL + BLANK_SPACE + strikeNumbers + STRIKE);
    }

    public void printAnswerMessage() {
        System.out.println(ANSWER_MESSAGE);
    }

    public void printRestartOrEndInputMessage() {
        System.out.println(RESTART_OR_END_INPUT_MESSAGE);
    }
}
