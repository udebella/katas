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
}