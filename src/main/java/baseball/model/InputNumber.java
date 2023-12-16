package baseball.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class InputNumber {

    private static final int NUMBER_OF_NUMBERS = 3;

    private final List<Integer> numbers;

    private InputNumber(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static InputNumber create(final String inputNumber) {
        if (hasDuplicate(inputNumber)) {
            throw new IllegalArgumentException();
        }
        final List<Integer> numbers = toList(inputNumber);
        boolean isNotInRange = numbers.stream()
                .anyMatch(i -> i < 1 || i > 9);
        if (isNotInRange) {
            throw new IllegalArgumentException();
        }
        return new InputNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private static boolean hasDuplicate(final String inputNumber) {
        final long count = IntStream.range(0, NUMBER_OF_NUMBERS)
                .mapToObj(inputNumber::charAt)
                .distinct()
                .count();
        return count != inputNumber.length();
    }

    private static List<Integer> toList(final String inputNumber) {
        return IntStream.range(0, NUMBER_OF_NUMBERS)
                .mapToObj(i -> Character.getNumericValue(inputNumber.charAt(i)))
                .toList();
    }
}
