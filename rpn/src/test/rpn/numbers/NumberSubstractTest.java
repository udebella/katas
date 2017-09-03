package rpn.numbers;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class NumberSubstractTest {
    @Test
    public void substract_zero_to_zero_should_produce_zero() throws Exception {
        Assertions.assertThat(Number.ZERO.substract(Number.ZERO)).isEqualTo(Number.ZERO);
    }

    @Test
    public void substract_a_number_to_zero_should_produce_the_same_number() throws Exception {
        Assertions.assertThat(Number.of("1").substract(Number.ZERO)).isEqualTo(Number.of("1"));
    }

    @Test
    public void substract_zero_to_a_number_should_produce_the_opposite() throws Exception {
        Assertions.assertThat(Number.ZERO.substract(Number.of("1"))).isEqualTo(Number.of("-1"));
    }

    @Test
    public void substract_two_numbers_should_produce_substraction() throws Exception {
        Assertions.assertThat(Number.of("1").substract(Number.of("2"))).isEqualTo(Number.of("-1"));
    }
}