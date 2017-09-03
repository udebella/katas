package rpn;

public class Number {
    public static final Number ZERO = new Number(0);
    private final int number;

    public static Number of(String number) {
        assert number != null;
        if (number.length() == 0) {
            return ZERO;
        }
        return new Number(number);
    }

    private Number(String number) {
        this.number = Integer.valueOf(number);
    }

    private Number(int number) {
        this.number = number;
    }

    public Number add(Number numberToAdd) {
        return new Number(numberToAdd.number + number);
    }

    public Number substract(Number number) {
        return this;
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
