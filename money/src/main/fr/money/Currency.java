package fr.money;

import java.math.BigDecimal;

public enum Currency {
    WONS(136216),
    FORINTS(30664),
    POUND(91),
    HONG_KONG_DOLLARS(940),
    CZECK_KORUNAS(2610),
    DOLLARS(120),
    YENS(12972),
    EUROS(100),
    DINAR(140143);

    private final BigDecimal rate;

    Currency(int rateInCents) {
        this.rate = new BigDecimal(rateInCents).divide(new BigDecimal(100), 2, BigDecimal.ROUND_CEILING);
    }

    public BigDecimal to(Currency currency) {
        return currency.rate
                .divide(this.rate, 10, BigDecimal.ROUND_CEILING)
                .stripTrailingZeros();
    }
}
