package rpn.numbers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.numbers.Number.ZERO;

public class NumberSubstractTest {
    @Test
    public void substract_zero_to_zero_should_produce_zero() throws Exception {
        final Number result = ZERO.substract(ZERO);

        assertThat(result).isEqualTo(ZERO);
    }

    @Test
    public void substract_a_number_to_zero_should_produce_the_same_number() throws Exception {
        final Number one = Number.of("1");

        final Number result = one.substract(ZERO);

        assertThat(result).isEqualTo(one);
    }

    @Test
    public void substract_zero_to_a_number_should_produce_the_opposite() throws Exception {
        final Number one = Number.of("1");
        final Number minusOne = Number.of("-1");

        final Number result = ZERO.substract(one);

        assertThat(result).isEqualTo(minusOne);
    }

    @Test
    public void substract_two_numbers_should_produce_substraction() throws Exception {
        final Number one = Number.of("1");
        final Number two = Number.of("2");
        final Number minusOne = Number.of("-1");

        final Number result = one.substract(two);

        assertThat(result).isEqualTo(minusOne);
    }
}