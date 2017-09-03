package rpn;

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

    @Test
    public void adding_zero_to_zero_should_produce_zero() throws Exception {
        assertThat(Number.ZERO.add(Number.ZERO)).isEqualTo(Number.ZERO);
    }

    @Test
    public void adding_zero_to_another_number_should_produce_the_other_number() throws Exception {
        assertThat(Number.ZERO.add(Number.of("4"))).isEqualTo(Number.of("4"));
    }

    @Test
    public void adding_two_number_should_produce_sum_of_these_numbers() throws Exception {
        assertThat(Number.of("1").add(Number.of("1"))).isEqualTo(Number.of("2"));
    }

    @Test
    public void substract_zero_to_zero_should_produce_zero() throws Exception {
        assertThat(Number.ZERO.substract(Number.ZERO)).isEqualTo(Number.ZERO);
    }

    @Test
    public void substract_a_number_to_zero_should_produce_the_same_number() throws Exception {
        assertThat(Number.of("1").substract(Number.ZERO)).isEqualTo(Number.of("1"));
    }

    @Test
    public void substract_zero_to_a_number_should_produce_the_opposite() throws Exception {
        assertThat(Number.ZERO.substract(Number.of("1"))).isEqualTo(Number.of("-1"));
    }
}