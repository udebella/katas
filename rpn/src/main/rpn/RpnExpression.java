package rpn;

import java.util.Stack;

public class RpnExpression {
    private static final String SEPARATOR = " ";
    private Stack<Number> parts = new Stack<>();

    private RpnExpression(String expression) {
        for (String part : expression.split(SEPARATOR)) {
            Number number = Operation.of(part)
                    .map(operation -> operation.applyOperation(parts.pop(), parts.pop()))
                    .orElseGet(() -> new Number(part));
            parts.push(number);
        }
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

        return parts.equals(that.parts);
    }

    @Override
    public int hashCode() {
        return parts.hashCode();
    }

    @Override
    public String toString() {
        return "RpnExpression{" +
                "parts=" + parts +
                '}';
    }
}
