package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameValidatorTest {
    @Test
    @DisplayName("이름 입력 통과 케이스")
    void testName() {
        //given
        List<String> input = List.of("a", "b", "c");
        //when
        //then
        CarNameValidator.validateNameLength(input);
    }

    @Test
    @DisplayName("이름 5자 초과시 실패")
    void testNameLength() {
        //given
        List<String> input = List.of("abcdef", "b", "c");
        //when
        //then
        assertThatThrownBy(() -> CarNameValidator.validateNameLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 5자 이하만 가능합니다.\n");
    }

    @Test
    @DisplayName("중복된 이름 있을시 실패")
    void testDuplicatedName() {
        //given
        List<String> input = List.of("a", "a", "c");
        //when
        //then
        assertThatThrownBy(() -> CarNameValidator.validateDuplicatedName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름입니다.\n");
    }

    @Test
    @DisplayName("이름 공백 포함시 실패")
    void testIfNameIsEmpty() {
        //given
        List<String> input = List.of("a", " ", "c");
        //when
        //then
        assertThatThrownBy(() -> CarNameValidator.validateWhiteSpace(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름을 입력해주세요.\n");
    }
}