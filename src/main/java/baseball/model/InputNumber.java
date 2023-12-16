package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

public class InputNumber {

    private final List<Integer> numbers;

    private InputNumber(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static void create(final String inputNumber) {
        if (hasDuplicate(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicate(final String inputNumber) {
        final long count = IntStream.range(0, 3)
                .mapToObj(inputNumber::charAt)
                .distinct()
                .count();
        return count != inputNumber.length();
    }
}
