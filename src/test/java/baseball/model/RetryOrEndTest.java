package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RetryOrEndTest {

    @Test
    void 일을_입력하면_재시작() {
        // given
        final int command = 1;

        // when
        final RetryOrEnd retryOrEnd = new RetryOrEnd();
        final boolean canRetry = retryOrEnd.canRetry(command);

        // then
        Assertions.assertTrue(canRetry);
    }

    @Test
    void 이를_입력하면_종료() {
        // given
        final int command = 2;

        // when
        final RetryOrEnd retryOrEnd = new RetryOrEnd();
        final boolean isEnd = retryOrEnd.canRetry(command);

        // then
        Assertions.assertFalse(isEnd);
    }
}
