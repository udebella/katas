package fr.money;

import java.math.BigDecimal;

public enum Currency {
    WONS(new BigDecimal(75).divide(new BigDecimal(100_000))),
    FORINTS(new BigDecimal(33).divide(new BigDecimal(1_000))),
    PENCES(new BigDecimal(109).divide(new BigDecimal(100_000))),
    HONG_KONG_DOLLARS(new BigDecimal(84).divide(new BigDecimal(100))),
    CZECK_KORUNAS(new BigDecimal(3831).divide(new BigDecimal(10_000))),
    DOLLARS(new BigDecimal(84).divide(new BigDecimal(100))),
    YENS(new BigDecimal(76).divide(new BigDecimal(1_000))),
    EUROS(BigDecimal.ONE),
    DINAR(new BigDecimal(72).divide(new BigDecimal(10_000)));

    private final BigDecimal rate;

    Currency(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal to(Currency currency) {
        return currency.rate;
    }
}
