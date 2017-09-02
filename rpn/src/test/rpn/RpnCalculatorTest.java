package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnCalculatorTest {
    @Test
    public void should_handle_empty_string() throws Exception {
        assertThat(new RpnCalculator().calcul("")).isEqualTo(0);
    }
}
