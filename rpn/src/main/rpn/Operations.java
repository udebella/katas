package rpn;

import rpn.numbers.Number;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;

public enum Operations {
    SUM("+", Number::add);

    private final String operator;
    private final BinaryOperator<Number> operation;

    Operations(String operator, BinaryOperator<Number> operation) {
        this.operation = operation;
        this.operator = operator;
    }

    public Number applyOperation(Number number1, Number number2) {
        return operation.apply(number1, number2);
    }

    public static Optional<Operations> of(String part) {
        assert part != null;
        return Arrays.stream(Operations.values())
                .filter(operations -> operations.compareOperator(part))
                .findAny();
    }

    private boolean compareOperator(String part) {
        return operator.equals(part);
    }
}
