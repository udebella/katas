package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnExpressionFeature {
    @Test
    public void should_handle_a_simple_addition() throws Exception {
        final RpnExpression expression = RpnExpression.of("1 1 +");

        final RpnExpression result = RpnExpression.of("2");

        assertThat(expression).isEqualTo(result);
    }

    @Test
    public void should_handle_a_simple_substraction() throws Exception {
        final RpnExpression expression = RpnExpression.of("1 1 -");

        final RpnExpression result = RpnExpression.of("0");

        assertThat(expression).isEqualTo(result);
    }

    @Test
    public void should_apply_numbers_in_order() throws Exception {
        final RpnExpression expression = RpnExpression.of("1 2 -");

        final RpnExpression result = RpnExpression.of("-1");

        assertThat(expression).isEqualTo(result);
    }

    @Test
    public void should_handle_a_simple_multiplication() throws Exception {
        final RpnExpression expression = RpnExpression.of("1 2 *");

        final RpnExpression result = RpnExpression.of("2");

        assertThat(expression).isEqualTo(result);
    }

    @Test
    public void should_handle_a_simple_division() throws Exception {
        final RpnExpression expression = RpnExpression.of("1 1 /");

        final RpnExpression result = RpnExpression.of("1");

        assertThat(expression).isEqualTo(result);
    }

    @Test
    public void should_allow_to_do_multiple_operations_in_one_expression() throws Exception {
        final RpnExpression expression = RpnExpression.of("4 2 + 3 -");

        final RpnExpression result = RpnExpression.of("3");

        assertThat(expression).isEqualTo(result);
    }

    @Test
    public void multiple_operations_feature() throws Exception {
        final RpnExpression expression = RpnExpression.of("3 5 8 * 7 + *");

        final RpnExpression result = RpnExpression.of("141");

        assertThat(expression).isEqualTo(result);
    }

    @Test
    public void multiple_results() throws Exception {
        final RpnExpression expression = RpnExpression.of("7 2 - 3 4");

        final RpnExpression result = RpnExpression.of("5 3 4");

        assertThat(expression).isEqualTo(result);
    }
}
