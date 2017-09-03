package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnExpressionTest {
    @Test(expected = AssertionError.class)
    public void should_not_allow_to_create_with_null_expression() throws Exception {
        RpnExpression.of(null);
    }

    @Test
    public void should_be_comparable() throws Exception {
        assertThat(RpnExpression.of("")).isEqualTo(RpnExpression.of(""));
        assertThat(RpnExpression.of("")).isNotEqualTo(RpnExpression.of("1"));
    }

    @Test
    public void should_handle_empty_string() throws Exception {
        final RpnExpression expression = RpnExpression.of("");

        assertThat(expression.evaluate()).isEqualTo(RpnExpression.of(""));
    }

    @Test
    public void should_handle_simple_number_in_rpn_expression() throws Exception {
        final RpnExpression expression = RpnExpression.of("1");

        assertThat(expression.evaluate()).isEqualTo(RpnExpression.of("1"));
    }

    @Test
    public void should_handle_a_simple_addition() throws Exception {
        final RpnExpression expression = RpnExpression.of("1 1 +");

        assertThat(expression.evaluate()).isEqualTo(RpnExpression.of("2"));
    }
}