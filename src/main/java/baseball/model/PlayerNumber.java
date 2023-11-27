package baseball.model;

public class PlayerNumber {

    private final String playerNumber;

    public PlayerNumber(final String playerNumber) {
        InputNumberValidator.validateInputThreeNumber(playerNumber);
        this.playerNumber = playerNumber;
    }

    public char getOneNumberByIndex(final int index) {
        return playerNumber.charAt(index);
    }
}
