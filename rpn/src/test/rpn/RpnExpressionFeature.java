package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RpnExpressionFeature {
    @Test
    public void multiple_operations_feature() throws Exception {
        final RpnExpression expression = RpnExpression.of("3 5 8 * 7 + *");

        assertThat(expression).isEqualTo(RpnExpression.of("141"));
    }

    @Test
    public void multiple_results() throws Exception {
        final RpnExpression expression = RpnExpression.of("7 2 - 3 4");

        assertThat(expression).isEqualTo(RpnExpression.of("5 3 4"));
    }
}
