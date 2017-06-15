import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * Created by Ubu on 11/05/2017.
 */
public enum OP {
    divide("/", (a, b) -> b / a),
    add("+", (a, b) -> b + a),
    sub("-", (a, b) -> b - a);

    public static boolean isOperator(String symbol) {
        return Arrays.stream(OP.values()).anyMatch(op -> op.symbol.equals(symbol));
    }

    public static OP findBySymbol(String symbol) {
        Optional<OP> op = Arrays.stream(OP.values())
                .filter(s -> s.symbol.equals(symbol))
                .findAny();
        return op.orElseThrow(() -> new IllegalStateException("Unknown operator"));
    }

    private final String symbol;
    private final BinaryOperator<Integer> function;

    OP(String symbol, BinaryOperator<Integer> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public int calc(int operand1, int operand2) {
        return this.function.apply(operand1, operand2);
    }
}
