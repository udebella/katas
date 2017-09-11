package fr.money;

import java.math.BigDecimal;

public class Amount implements RateVisitor {
    private final BigDecimal value;

    public Amount(int value) {
        this.value = new BigDecimal(value);
    }

    private Amount(BigDecimal divide) {
        this.value = divide;
    }

    public Amount cents() {
        return new Amount(value.divide(new BigDecimal(100)));
    }

    public Amount apply(Rate rate) {
        return rate.accept(this);
    }

    @Override
    public Amount visit(BigDecimal rate) {
        return new Amount(value.multiply(rate));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return value.equals(amount.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
