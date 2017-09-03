package rpn;

import java.util.function.IntBinaryOperator;

public class Number {
    private final int number;

    public Number(String number) {
        if (number.length() == 0) {
            this.number = 0;
        } else {
            this.number = Integer.valueOf(number);
        }
    }

    public Number(int number) {
        this.number = number;
    }

    public Number apply(IntBinaryOperator operation, Number number2) {
        int result = operation.applyAsInt(number, number2.number);
        return new Number(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number1 = (Number) o;

        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
