package baseball.model;

public class PlayerNumber {

    private final String playerNumber;

    public PlayerNumber(final String playerNumber) {
        InputNumberValidator.validateInputThreeNumber(playerNumber);
        this.playerNumber = playerNumber;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }
}
