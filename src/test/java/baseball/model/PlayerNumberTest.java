package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerNumberTest {

    @Test
    public void 중복된_숫자_입력시_예외_발생() {
        assertThatThrownBy(() -> new PlayerNumber("144"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_문자열에_문자가_포함되어_있으면_예외_발생() {
        assertThatThrownBy(() -> new PlayerNumber("14j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_숫자_개수가_3개가_넘으면_예외_발생() {
        assertThatThrownBy(() -> new PlayerNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_숫자_개수가_3개보다_적으면_예외_발생() {
        assertThatThrownBy(() -> new PlayerNumber("34"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 재시작_또는_종료_숫자를_잘못_입력하면_예외_발생() {
        assertThatThrownBy(() -> InputNumberValidator.validateRestartOrEnd("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_숫자가_1에서_9사이의_숫자가_아니면_예외_발생() {
        assertThatThrownBy(() -> new PlayerNumber("012"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_숫자에서_인덱스에_위치한_숫자찾기_테스트() {
        // given
        final PlayerNumber playerNumber = new PlayerNumber("153");
        final int index = 1;

        // when
        final char oneNumberByIndex = playerNumber.getOneNumberByIndex(index);

        // then
        Assertions.assertEquals(oneNumberByIndex, '5');
    }
}