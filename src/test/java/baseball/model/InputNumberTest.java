package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputNumberTest {

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

    @Test
    void 서로_다른_3개의_숫자가_아닌_경우_예외가_발생한다() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputNumber.create("112"));
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputNumber.create("119"));
    }

    @Test
    void 숫자의_범위를_벗어나면_예외가_발생한다() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputNumber.create("012"));
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputNumber.create("097"));
    }
}
