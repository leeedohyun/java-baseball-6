package baseball.model;

import java.util.Collections;
import java.util.List;

public class RandomNumber {

    private final List<Integer> numbers;

    private RandomNumber(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static RandomNumber create(final List<Integer> numbers) {
        return new RandomNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
