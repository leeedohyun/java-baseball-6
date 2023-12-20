package baseball.model;

import java.util.Collections;
import java.util.List;

public class RandomNumber {

    private final List<Integer> numbers;

    private RandomNumber(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static RandomNumber create(final RandomNumberGenerator randomNumberGenerator) {
        return new RandomNumber(randomNumberGenerator.generate());
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getRandomNumberByIndex(final int index) {
        return numbers.get(index);
    }

    public boolean hasNumber(final int number) {
        return numbers.contains(number);
    }
}
