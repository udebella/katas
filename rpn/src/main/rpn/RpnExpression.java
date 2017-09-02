package rpn;

public class RpnExpression {
    private String expression;

    public RpnExpression(String expression) {
        this.expression = expression;
    }

    public static RpnExpression of(String expression) {
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
