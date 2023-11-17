package baseball.model;

public class ComputerNumber {

    private static final String EMPTY_STRING = "";

    private String computerNumber = EMPTY_STRING;

    public ComputerNumber() {
        this.computerNumber = generateRandomNumbers();
    }

    private String generateRandomNumbers() {
        final RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.create();
        return randomNumberGenerator.getStringRandomNumbers();
    }

    public String getComputerNumber() {
        return computerNumber;
    }
}
