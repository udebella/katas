package fr.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rate {
    private final BigDecimal rate;

    public Rate(int rate) {
        this.rate = new BigDecimal(rate);
    }

    public Rate(BigDecimal rate) {
        this.rate = rate;
    }

    public Rate divide(Rate rate) {
        if (BigDecimal.ZERO.equals(rate.rate)) {
            throw new ArithmeticException();
        }
        return new Rate(this.rate
                .divide(rate.rate, 10, RoundingMode.CEILING)
                .stripTrailingZeros());
    }

    public <T extends RateVisitor> T accept(RateVisitor rateVisitor) {
        return rateVisitor.visit(rate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rate rate1 = (Rate) o;

        return rate.equals(rate1.rate);
    }

    @Override
    public int hashCode() {
        return rate.hashCode();
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rate=" + rate +
                '}';
    }
}
