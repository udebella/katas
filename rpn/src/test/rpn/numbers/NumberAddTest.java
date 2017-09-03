package rpn.numbers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.numbers.Number.ZERO;

public class NumberAddTest {
    @Test
    public void adding_zero_to_zero_should_produce_zero() throws Exception {
        final Number result = ZERO.add(ZERO);

        assertThat(result).isEqualTo(ZERO);
    }

    @Test
    public void adding_zero_to_another_number_should_produce_the_other_number() throws Exception {
        final Number four = Number.of("4");

        final Number result = ZERO.add(four);

        assertThat(result).isEqualTo(four);
    }

    @Test
    public void adding_two_number_should_produce_sum_of_these_numbers() throws Exception {
        final Number one = Number.of("1");
        final Number two = Number.of("2");

        final Number result = one.add(one);

        assertThat(result).isEqualTo(two);
    }
}