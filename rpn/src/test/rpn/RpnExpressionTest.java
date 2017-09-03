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
        final RpnExpression emptyExpression = RpnExpression.of("");
        final RpnExpression oneExpression = RpnExpression.of("1");
        assertThat(emptyExpression).isNotEqualTo(oneExpression);
    }

    @Test
    public void two_instances_of_same_expression_should_be_the_same() throws Exception {
        final RpnExpression emptyExpression1 = RpnExpression.of("");
        final RpnExpression emptyExpression2 = RpnExpression.of("");

        assertThat(emptyExpression2).isEqualTo(emptyExpression1);
    }

    @Test
    public void should_handle_simple_number_in_rpn_expression() throws Exception {
        final RpnExpression expression = RpnExpression.of("1");

        final RpnExpression result = RpnExpression.of("1");

        assertThat(expression).isEqualTo(result);
    }

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
}