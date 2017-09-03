package rpn.numbers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberMultiplyTest {
    @Test
    public void multiply_zero_by_zero_should_produce_zero() throws Exception {
        assertThat(Number.ZERO.multiply(Number.ZERO)).isEqualTo(Number.ZERO);
    }

    @Test
    public void multiply_a_number_by_zero_should_produce_zero() throws Exception {
        assertThat(Number.of("5").multiply(Number.ZERO)).isEqualTo(Number.ZERO);
    }

    @Test
    public void multiply_zero_by_a_number_should_produce_zero() throws Exception {
        assertThat(Number.ZERO.multiply(Number.of("5"))).isEqualTo(Number.ZERO);
    }

    @Test
    public void multiply_two_numbers_should_produce_multiplication() throws Exception {
        assertThat(Number.of("2").multiply(Number.of("5"))).isEqualTo(Number.of("10"));
    }
}