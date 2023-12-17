package baseball.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(final int strike, final int ball) {
        printNothing(strike, ball);
        printOnlyStrike(strike, ball);
        printOnlyBall(strike, ball);
        printStrikeAndBall(strike, ball);
    }

    public void printThreeStrike(final int strike) {
        System.out.println(strike + "스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void printNothing(final int strike, final int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

    private void printOnlyStrike(final int strike, final int ball) {
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }
    }

    private void printOnlyBall(final int strike, final int ball) {
        if (strike == 0) {
            System.out.println(ball + "볼");
        }
    }

    private void printStrikeAndBall(final int strike, final int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
