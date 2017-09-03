package rpn;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

public enum Operation {
    SUM("+", (int number1, int number2) -> number1 + number2);

    private final String operator;
    private final IntBinaryOperator operation;

    Operation(String operator, IntBinaryOperator operation) {
        this.operation = operation;
        this.operator = operator;
    }

    public Number applyOperation(Number number1, Number number2) {
        return number1.apply(operation, number2);
    }

    public static Optional<Operation> of(String part) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.operator.equals(part))
                .findAny();
    }
}
