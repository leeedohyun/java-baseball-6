package baseball.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class InputNumber {

    private final List<Integer> numbers;

    private InputNumber(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static InputNumber create(final String inputNumber) {
        if (hasDuplicate(inputNumber)) {
            throw new IllegalArgumentException();
        }

        final List<Integer> numbers = IntStream.range(0, 3)
                .mapToObj(i -> Character.getNumericValue(inputNumber.charAt(i)))
                .toList();

        return new InputNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private static boolean hasDuplicate(final String inputNumber) {
        final long count = IntStream.range(0, 3)
                .mapToObj(inputNumber::charAt)
                .distinct()
                .count();
        return count != inputNumber.length();
    }
}
