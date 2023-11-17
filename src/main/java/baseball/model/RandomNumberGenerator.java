package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator {

    private final List<Integer> randomNumbers;

    private RandomNumberGenerator(final List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public static RandomNumberGenerator create() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Constants.NUMBER_OF_NUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(Constants.START_NUMBER, Constants.END_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new RandomNumberGenerator(computer);
    }

    public String getStringRandomNumbers() {
        return randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    @Override
    public String toString() {
        return "RandomNumberGenerator{" +
                "randomNumbers=" + randomNumbers +
                '}';
    }
}
