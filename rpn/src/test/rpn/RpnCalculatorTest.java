package rpn;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnCalculatorTest {
    private RpnCalculator rpnCalculator;

    @Before
    public void setUp() throws Exception {
        rpnCalculator = new RpnCalculator();
    }

    @Test
    public void should_handle_empty_string() throws Exception {
        assertThat(rpnCalculator.calcul("")).isEqualTo("");
    }

    @Test
    public void should_handle_simple_number_in_rpn_expression() throws Exception {
        assertThat(rpnCalculator.calcul("1")).isEqualTo("1");
    }
}
