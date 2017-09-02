package rpn;

import org.junit.Test;

public class RpnExpressionTest {
    @Test(expected = AssertionError.class)
    public void should_not_allow_to_create_with_null_expression() throws Exception {
        RpnExpression.of(null);
    }
}