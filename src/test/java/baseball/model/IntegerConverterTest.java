package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IntegerConverterTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "a23", "4d2"})
    void 숫자가_아니면_예외가_발생한다(final String input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> IntegerConverter.convert(input));
    }
}
