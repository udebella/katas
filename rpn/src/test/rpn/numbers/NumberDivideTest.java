package rpn.numbers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static rpn.numbers.Number.ZERO;

public class NumberDivideTest {
    @Test
    public void divide_zero_by_one_should_produce_zero() throws Exception {
        Number one = Number.of("1");

        final Number result = ZERO.divide(one);

        assertThat(result).isEqualTo(ZERO);
    }
}