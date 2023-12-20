package baseball.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @Test
    void 일을_입력하면_재시작() {
        // given
        final int command = 1;

        // when
        final boolean canRetry = GameCommand.canRetry(command);

        // then
        Assertions.assertTrue(canRetry);
    }

    @Test
    void 이를_입력하면_종료() {
        // given
        final int command = 2;

        // when
        final boolean isEnd = GameCommand.canRetry(command);

        // then
        Assertions.assertFalse(isEnd);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 4, 6})
    void 일과_이를_제외한_숫자를_입력하면_예외가_발생한다(final int command) {
        assertThatIllegalArgumentException().isThrownBy(() -> GameCommand.canRetry(command));
    }
}
