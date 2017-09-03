package rpn;

public class Number {
    private final int number;

    public Number(String number) {
        if (number.length() == 0) {
            this.number = 0;
        } else {
            this.number = Integer.valueOf(number);
        }
    }

    private Number(int number) {
        this.number = number;
    }

    public Number add(Number numberToAdd) {
        return new Number(numberToAdd.number + number);
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
