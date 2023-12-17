package baseball.model;

public class RetryOrEnd {

    private static final int RETRY = 1;
    private static final int END = 2;

    private RetryOrEnd() {
    }

    public static boolean canRetry(final int command) {
        if (command != RETRY && command != END) {
            throw new IllegalArgumentException();
        }
        return command == RETRY;
    }
}
