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

    private final Rate rate;

    Currency(int rateInCents) {
        final BigDecimal hundred = new BigDecimal(100);
        final BigDecimal divide = new BigDecimal(rateInCents).divide(hundred, 2, BigDecimal.ROUND_CEILING);
        this.rate = new Rate(divide);
    }

    public Rate to(Currency currency) {
        return currency.rate
                .divide(this.rate);
    }
}
