package fr.money;

import java.math.BigDecimal;

public enum Currency {
    WONS, FORINTS, PENCES, HONG_KONG_DOLLARS, CZECK_KORUNAS, DOLLARS, YENS, EUROS, DINAR;

    public BigDecimal to(Currency currency) {
        return BigDecimal.ONE;
    }
}
