package rpn;

import java.util.Stack;

public class RpnExpression {
    private static final String SEPARATOR = " ";
    private Stack<String> parts = new Stack<>();

    public RpnExpression(String expression) {
        for (String part : expression.split(SEPARATOR)) {
            parts.push(part);
        }
    }

    public RpnExpression evaluate() {
        StringBuilder result = new StringBuilder();

        String part = parts.pop();
        if ("+".equals(part)) {
            final String number1 = parts.pop();
            final String number2 = parts.pop();
            final int sum = Integer.valueOf(number1) + Integer.valueOf(number2);
            result.append(sum);
        } else {
            result.append(part);
        }
        return RpnExpression.of(result.toString());
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
