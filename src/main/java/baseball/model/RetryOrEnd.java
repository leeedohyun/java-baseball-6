package baseball.model;

public class RetryOrEnd {

    public boolean canRetry(final int command) {
        if (command != 1 && command != 2) {
            throw new IllegalArgumentException();
        }
        return command == 1;
    }
}
