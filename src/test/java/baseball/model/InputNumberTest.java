package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputNumberTest {

    @Test
    void 서로_다른_3개의_숫자가_아닌_경우_예외가_발생한다() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputNumber.create("112"));
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputNumber.create("119"));
    }
}
