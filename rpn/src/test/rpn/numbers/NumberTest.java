package rpn.numbers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {
    @Test(expected = AssertionError.class)
    public void creating_numbers_with_null_value_should_be_forbidden() throws Exception {
        Number.of(null);
    }

    @Test
    public void numbers_should_be_comparable() throws Exception {
        assertThat(Number.of("1").equals(Number.of("1"))).isTrue();
        assertThat(Number.of("1").equals(Number.of("2"))).isFalse();
    }

    @Test
    public void creating_numbers_with_empty_string_should_produce_zero() throws Exception {
        assertThat(Number.of("")).isEqualTo(Number.ZERO);
    }

}