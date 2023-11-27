package baseball.model;

public class ComputerNumber {

    private final String computerNumber;

    private ComputerNumber(final String computerNumber) {
        this.computerNumber = computerNumber;
    }

    public static ComputerNumber create() {
        final RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.create();
        return new ComputerNumber(randomNumberGenerator.getStringRandomNumbers());
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
