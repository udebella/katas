package rpn.numbers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.numbers.Number.ZERO;

public class NumberMultiplyTest {
    @Test
    public void multiply_zero_by_zero_should_produce_zero() throws Exception {
        final Number result = ZERO.multiply(ZERO);

        assertThat(result).isEqualTo(ZERO);
    }

    @Test
    public void multiply_a_number_by_zero_should_produce_zero() throws Exception {
        final Number five = Number.of("5");

        final Number result = five.multiply(ZERO);

        assertThat(result).isEqualTo(ZERO);
    }

    @Test
    public void multiply_zero_by_a_number_should_produce_zero() throws Exception {
        final Number five = Number.of("5");

        final Number result = ZERO.multiply(five);

        assertThat(result).isEqualTo(ZERO);
    }

    @Test
    public void multiply_two_numbers_should_produce_multiplication() throws Exception {
        final Number two = Number.of("2");
        final Number five = Number.of("5");
        final Number ten = Number.of("10");

        final Number result = two.multiply(five);

        assertThat(result).isEqualTo(ten);
    }
}