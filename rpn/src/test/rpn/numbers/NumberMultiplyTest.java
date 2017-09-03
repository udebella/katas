package rpn.numbers;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class NumberMultiplyTest {
    @Test
    public void multiply_zero_to_zero_should_produce_zero() throws Exception {
        Assertions.assertThat(Number.ZERO.multiply(Number.ZERO)).isEqualTo(Number.ZERO);
    }
}