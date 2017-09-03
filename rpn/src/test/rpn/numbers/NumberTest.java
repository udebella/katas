package rpn.numbers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.numbers.Number.ZERO;

public class NumberTest {
    @Test(expected = AssertionError.class)
    public void creating_numbers_with_null_value_should_be_forbidden() throws Exception {
        Number.of(null);
    }

    @Test
    public void numbers_should_be_comparable() throws Exception {
        final Number one = Number.of("1");
        final Number two = Number.of("2");

        final boolean comparison = one.equals(two);

        assertThat(comparison).isFalse();
    }

    @Test
    public void two_instances_of_same_number_should_be_the_same() throws Exception {
        final Number one1 = Number.of("1");
        final Number one2 = Number.of("1");

        final boolean comparison = one1.equals(one2);

        assertThat(comparison).isTrue();
    }

    @Test
    public void creating_numbers_with_empty_string_should_produce_zero() throws Exception {
        final Number empty = Number.of("");

        assertThat(empty).isEqualTo(ZERO);
    }

}