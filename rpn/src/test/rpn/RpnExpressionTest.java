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
}