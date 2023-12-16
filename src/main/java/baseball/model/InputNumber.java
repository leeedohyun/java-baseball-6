package baseball.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class InputNumber {

    private static final int NUMBER_OF_NUMBERS = 3;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    private final List<Integer> numbers;

    private InputNumber(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static InputNumber create(final String inputNumber) {
        final List<Integer> numbers = toList(inputNumber);

        if (hasDuplicate(inputNumber)) {
            throw new IllegalArgumentException();
        }
        if (isNotInRange(numbers)) {
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

    private static boolean isNotInRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_RANGE || number > MAX_RANGE);
    }
}
