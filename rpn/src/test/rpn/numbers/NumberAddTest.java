package rpn.numbers;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class NumberAddTest {
    @Test
    public void adding_zero_to_zero_should_produce_zero() throws Exception {
        Assertions.assertThat(Number.ZERO.add(Number.ZERO)).isEqualTo(Number.ZERO);
    }

    @Test
    public void adding_zero_to_another_number_should_produce_the_other_number() throws Exception {
        Assertions.assertThat(Number.ZERO.add(Number.of("4"))).isEqualTo(Number.of("4"));
    }

    @Test
    public void adding_two_number_should_produce_sum_of_these_numbers() throws Exception {
        Assertions.assertThat(Number.of("1").add(Number.of("1"))).isEqualTo(Number.of("2"));
    }
}