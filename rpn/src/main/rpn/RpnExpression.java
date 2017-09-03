package rpn;

import java.util.Stack;

public class RpnExpression {
    private Stack<String> parts = new Stack<>();

    public RpnExpression(String expression) {
        for (String part : expression.split(" ")) {
            parts.push(part);
        }
    }

    public RpnExpression evaluate() {
        if ("+".equals(parts.peek())) {
            parts.pop();
            return RpnExpression.of(String.valueOf(Integer.valueOf(parts.pop()) + Integer.valueOf(parts.pop())));
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
