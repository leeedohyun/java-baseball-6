package baseball.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    void 랜덤_넘버를_생성한다() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3);

        // when
        final RandomNumber randomNumber = RandomNumber.create(numbers);

        // then
        Assertions.assertThat(randomNumber.getNumbers()).hasSize(3)
                .contains(1, 2, 3);
    }
}