package rpn;

import java.util.Stack;

public class RpnExpression {
    private static final String SEPARATOR = " ";
    private final Stack<Number> parts = new Stack<>();

    public static RpnExpression of(String expression) {
        assert expression != null;
        return new RpnExpression(expression);
    }

    private RpnExpression(String expression) {
        for (String part : expression.split(SEPARATOR)) {
            evaluatePart(part);
        }
    }

    private void evaluatePart(String part) {
        Number number = Operation.of(part)
                .map(this::applyOperation)
                .orElseGet(() -> new Number(part));
        parts.push(number);
    }

    private Number applyOperation(Operation operation) {
        final Number number1 = parts.pop();
        final Number number2 = parts.pop();
        return operation.applyOperation(number1, number2);
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
