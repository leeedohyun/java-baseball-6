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
    void 원_스트라이크(final List<Integer> inputNumber, final List<Integer> randomNumber) {
        // when
        final BaseballGame baseballGame = new BaseballGame();
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
        final BaseballGame baseballGame = new BaseballGame();
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
        final BaseballGame baseballGame = new BaseballGame();
        final int strikeNumber = baseballGame.countStrike(inputNumber, randomNumber);

        // then
        Assertions.assertEquals(3, strikeNumber);
    }

    @ParameterizedTest
    @MethodSource("provideBallTestData")
    void 원_볼(final List<Integer> inputNumber, final List<Integer> randomNumber) {
        // when
        final BaseballGame baseballGame = new BaseballGame();
        final int ballNumber = baseballGame.countBall(inputNumber, randomNumber);

        // then
        Assertions.assertEquals(1, ballNumber);
    }

    @Test
    void 투_볼() {
        // given
        final List<Integer> inputNumber = List.of(1, 2, 3);
        final List<Integer> randomNumber = List.of(6, 1, 2);

        // when
        final BaseballGame baseballGame = new BaseballGame();
        final int ballNumber = baseballGame.countBall(inputNumber, randomNumber);

        // then
        Assertions.assertEquals(2, ballNumber);
    }

    @Test
    void 쓰리_볼() {
        // given
        final List<Integer> inputNumber = List.of(1, 2, 3);
        final List<Integer> randomNumber = List.of(2, 3, 1);

        // when
        final BaseballGame baseballGame = new BaseballGame();
        final int ballNumber = baseballGame.countBall(inputNumber, randomNumber);

        // then
        Assertions.assertEquals(3, ballNumber);
    }

    @ParameterizedTest
    @MethodSource("provideNothingTestData")
    void 낫싱(final List<Integer> inputNumber, final List<Integer> randomNumber) {
        // when
        final BaseballGame baseballGame = new BaseballGame();
        final int strikeNumber = baseballGame.countStrike(inputNumber, randomNumber);
        final int ballNumber = baseballGame.countBall(inputNumber, randomNumber);

        final boolean nothing = baseballGame.isNothing(strikeNumber, ballNumber);

        // then
        Assertions.assertTrue(nothing);
    }

    private static Stream<Arguments> provideStrikeTestData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 4, 5)),
                Arguments.of(List.of(1, 2, 3), List.of(6, 2, 5)));
    }

    private static Stream<Arguments> provideBallTestData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(6, 1, 7)),
                Arguments.of(List.of(4, 5, 6), List.of(6, 1, 7)));
    }

    private static Stream<Arguments> provideNothingTestData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 6)),
                Arguments.of(List.of(7, 8, 9), List.of(1, 3, 5)),
                Arguments.of(List.of(6, 2, 3), List.of(9, 1, 5)));
    }
}
