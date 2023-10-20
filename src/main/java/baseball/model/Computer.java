package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private String randomNumbers;

    public String generateRandomNumbers() {
        randomNumbers = "";

        while (randomNumbers.length() != Constants.NUMBER_OF_NUMBERS) {
            String randomNumber = String.valueOf(
                    Randoms.pickNumberInRange(Constants.START_NUMBER, Constants.END_NUMBER));

            addIfNotSame(randomNumber);
        }
        return randomNumbers;
    }

    private void addIfNotSame(String randomNumber) {
        if (!isSameNumber(randomNumber)) {
            randomNumbers += randomNumber;
        }
    }

    private boolean isSameNumber(String randomNumber) {
        return randomNumbers.contains(randomNumber);
    }
}
