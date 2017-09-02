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
        assertThat(rpnCalculator.calcul(RpnExpression.of(""))).isEqualTo(RpnExpression.of(""));
    }

    @Test
    public void should_handle_simple_number_in_rpn_expression() throws Exception {
        assertThat(rpnCalculator.calcul(RpnExpression.of("1"))).isEqualTo(RpnExpression.of("1"));
    }

    @Test(expected = AssertionError.class)
    public void should_not_allow_null_values() throws Exception {
        rpnCalculator.calcul(null);
    }
}
