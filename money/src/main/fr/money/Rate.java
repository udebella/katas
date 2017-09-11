package fr.money;

import java.math.BigDecimal;

public class Rate {
    private final int rate;

    public Rate(int rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return new BigDecimal(rate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rate rate1 = (Rate) o;

        return rate == rate1.rate;
    }

    @Override
    public int hashCode() {
        return rate;
    }
}
