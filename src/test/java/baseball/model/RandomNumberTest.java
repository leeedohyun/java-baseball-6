package baseball.model;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RandomNumberTest {

    @Test
    void 랜덤_넘버를_생성한다() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3);
        final RandomNumberGenerator mock = Mockito.mock(RandomNumberGenerator.class);
        Mockito.when(mock.generate()).thenReturn(numbers);

        // when
        final RandomNumber randomNumber = RandomNumber.create(mock);

        // then
        Assertions.assertThat(randomNumber.hasNumber(1)).isTrue();
        Assertions.assertThat(randomNumber.hasNumber(2)).isTrue();
        Assertions.assertThat(randomNumber.hasNumber(3)).isTrue();
    }
}
