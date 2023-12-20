package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputNumberTest {

    @Test
    void 서로_다른_3개의_숫자를_입력하면_InputNumber_객체가_생성된다() {
        // given
        final String input = "123";

        // when
        final InputNumber inputNumber = InputNumber.create(input);

        //then
        Assertions.assertThat(inputNumber.getNumbers()).hasSize(3)
                .contains(1, 2, 3);

        // given
        final String input2 = "456";

        // when
        final InputNumber inputNumber2 = InputNumber.create(input2);

        //then
        Assertions.assertThat(inputNumber2.getNumbers()).hasSize(3)
                .contains(4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "119"})
    void 서로_다른_3개의_숫자가_아닌_경우_예외가_발생한다(final String input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputNumber.create(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"012", "097"})
    void 숫자의_범위를_벗어나면_예외가_발생한다(final String input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputNumber.create(input));
    }
}
