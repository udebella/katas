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
    public void should_handle_simple_number_in_rpn_expression() throws Exception {
        final RpnExpression expression = RpnExpression.of("1");

        assertThat(expression).isEqualTo(RpnExpression.of("1"));
    }

    @Test
    public void should_handle_a_simple_addition() throws Exception {
        final RpnExpression expression = RpnExpression.of("1 1 +");

        assertThat(expression).isEqualTo(RpnExpression.of("2"));
    }

    @Test
    public void should_handle_a_simple_substraction() throws Exception {
        final RpnExpression expression = RpnExpression.of("1 1 -");

        assertThat(expression).isEqualTo(RpnExpression.of("0"));
    }

    @Test
    public void should_apply_numbers_in_order() throws Exception {
        final RpnExpression expression = RpnExpression.of("1 2 -");

        assertThat(expression).isEqualTo(RpnExpression.of("-1"));
    }

    @Test
    public void should_handle_a_simple_multiplication() throws Exception {
        final RpnExpression expression = RpnExpression.of("1 2 *");

        assertThat(expression).isEqualTo(RpnExpression.of("2"));
    }

    @Test
    public void should_handle_a_simple_division() throws Exception {
        final RpnExpression expression = RpnExpression.of("1 1 /");

        assertThat(expression).isEqualTo(RpnExpression.of("1"));
    }

    @Test
    public void should_allow_to_do_multiple_operations_in_one_expression() throws Exception {
        final RpnExpression expression = RpnExpression.of("4 2 + 3 -");

        assertThat(expression).isEqualTo(RpnExpression.of("3"));
    }
}