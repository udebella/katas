package rpn;

public class RpnExpression {
    private String expression;

    public RpnExpression(String expression) {
        this.expression = expression;
    }

    public RpnExpression evaluate() {
        if (expression.length() > 1) {
            return RpnExpression.of(String.valueOf(expression.charAt(0) - 48 + expression.charAt(2) - 48));
        }

        return this;
    }

    public static RpnExpression of(String expression) {
        assert expression != null;
        return new RpnExpression(expression);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RpnExpression that = (RpnExpression) o;

        return expression.equals(that.expression);
    }

    @Override
    public int hashCode() {
        return expression.hashCode();
    }
}
