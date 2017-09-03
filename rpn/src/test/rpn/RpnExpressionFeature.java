package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnExpressionFeature {
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
