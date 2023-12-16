package baseball.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

    @Test
    void 원_스트라이크() {
        // given
        final List<Integer> inputNumber = List.of(1, 2, 3);
        final List<Integer> randomNumber = List.of(1, 4, 5);

        // when
        BaseballGame baseballGame = new BaseballGame();
        final int strikeNumber = baseballGame.countStrike(inputNumber, randomNumber);

        // then
        Assertions.assertEquals(1, strikeNumber);

        // given
        final List<Integer> inputNumber2 = List.of(1, 2, 3);
        final List<Integer> randomNumber2 = List.of(6, 2, 5);

        // when
        BaseballGame baseballGame2 = new BaseballGame();
        final int strikeNumber2 = baseballGame2.countStrike(inputNumber2, randomNumber2);

        // then
        Assertions.assertEquals(1, strikeNumber2);
    }

    @Test
    void 투_스트라이크() {
        // given
        final List<Integer> inputNumber = List.of(1, 2, 3);
        final List<Integer> randomNumber = List.of(1, 2, 5);

        // when
        BaseballGame baseballGame = new BaseballGame();
        final int strikeNumber = baseballGame.countStrike(inputNumber, randomNumber);

        // then
        Assertions.assertEquals(2, strikeNumber);
    }

    @Test
    void 쓰리_스트라이크() {
        // given
        final List<Integer> inputNumber = List.of(1, 2, 3);
        final List<Integer> randomNumber = List.of(1, 2, 3);

        // when
        BaseballGame baseballGame = new BaseballGame();
        final int strikeNumber = baseballGame.countStrike(inputNumber, randomNumber);

        // then
        Assertions.assertEquals(3, strikeNumber);
    }
}
