package baseball.model;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseballGameTest {

    @ParameterizedTest
    @MethodSource("provideStrikeTestData")
    void 원_스트라이크(List<Integer> inputNumber, List<Integer> randomNumber) {
        // when
        BaseballGame baseballGame = new BaseballGame();
        final int strikeNumber = baseballGame.countStrike(inputNumber, randomNumber);

        // then
        Assertions.assertEquals(1, strikeNumber);
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

    private static Stream<Arguments> provideStrikeTestData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 4, 5)),
                Arguments.of(List.of(1, 2, 3), List.of(6, 2, 5)));
    }
}
