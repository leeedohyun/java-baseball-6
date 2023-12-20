package baseball.model;

public class GameCommand {

    private static final int RETRY = 1;
    private static final int END = 2;

    private GameCommand() {
    }

    public static boolean canRetry(final int command) {
        if (command != RETRY && command != END) {
            throw new IllegalArgumentException();
        }
        return command == RETRY;
    }
}
