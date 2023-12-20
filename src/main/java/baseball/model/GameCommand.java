package baseball.model;

public class GameCommand {

    private static final int RETRY = 1;
    private static final int END = 2;

    private final int command;

    public GameCommand(final int command) {
        validate(command);
        this.command = command;
    }

    public boolean canRetry() {
        return command == RETRY;
    }

    private void validate(final int command) {
        if (command != RETRY && command != END) {
            throw new IllegalArgumentException();
        }
    }
}
