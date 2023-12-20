package baseball.model;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

class BaseballGameTest {

    private RandomNumberGenerator mock;

    @BeforeEach
    void setUp() {
        mock = Mockito.mock(RandomNumberGenerator.class);
    }

    @ParameterizedTest
    @MethodSource("provideStrikeTestData")
    void 원_스트라이크(final String input, final List<Integer> random) {
        assertStrikeNumber(input, random, 1);
    }

    @Test
    void 투_스트라이크() {
        assertStrikeNumber("123", List.of(1, 2, 5), 2);
    }

    @Test
    void 쓰리_스트라이크() {
        assertStrikeNumber("123", List.of(1, 2, 3), 3);
    }

    @ParameterizedTest
    @MethodSource("provideBallTestData")
    void 원_볼(final String input, final List<Integer> random) {
        assertBallNumber(input, random, 1);
    }

    @Test
    void 투_볼() {
        assertBallNumber("123", List.of(6, 1, 2), 2);
    }

    @Test
    void 쓰리_볼() {
        assertBallNumber("123", List.of(2, 3, 1), 3);
    }

    private void assertStrikeNumber(final String input, final List<Integer> random, final int expected) {
        // given
        final InputNumber inputNumber = InputNumber.create(input);
        Mockito.when(mock.generate()).thenReturn(random);
        final RandomNumber randomNumber = RandomNumber.create(mock);

        // when
        final BaseballGame baseballGame = new BaseballGame(inputNumber, randomNumber);
        final int strikes = baseballGame.countStrike();

        // then
        Assertions.assertEquals(expected, strikes);
    }

    private void assertBallNumber(final String input, final List<Integer> random, final int expected) {
        // given
        final InputNumber inputNumber = InputNumber.create(input);
        Mockito.when(mock.generate()).thenReturn(random);
        final RandomNumber randomNumber = RandomNumber.create(mock);

        // when
        final BaseballGame baseballGame = new BaseballGame(inputNumber, randomNumber);
        final int balls = baseballGame.countBall();

        // then
        Assertions.assertEquals(expected, balls);
    }

    private static Stream<Arguments> provideStrikeTestData() {
        return Stream.of(
                Arguments.of("123", List.of(1, 4, 5)),
                Arguments.of("697", List.of(6, 2, 5)));
    }

    private static Stream<Arguments> provideBallTestData() {
        return Stream.of(
                Arguments.of("123", List.of(6, 1, 7)),
                Arguments.of("456", List.of(6, 1, 7)));
    }
}
