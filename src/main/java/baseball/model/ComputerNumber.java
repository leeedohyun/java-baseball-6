package baseball.model;

public class ComputerNumber {

    private static final String EMPTY_STRING = "";

    private String computerNumber = EMPTY_STRING;

    public ComputerNumber() {
        computerNumber = generateRandomNumbers();
    }

    private String generateRandomNumbers() {
        final RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.create();
        return randomNumberGenerator.getStringRandomNumbers();
    }

    public char getOneNumberByIndex(final int index) {
        return computerNumber.charAt(index);
    }

    public boolean hasInputNumber(final char inputNumber) {
        return computerNumber.chars()
                .mapToObj(i -> (char) i)
                .anyMatch(singleNumber -> singleNumber == inputNumber);
    }
}
