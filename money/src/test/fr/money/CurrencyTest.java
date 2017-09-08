package fr.money;

import org.junit.Test;

import java.math.BigDecimal;

import static fr.money.Currency.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyTest {
    @Test
    public void should_allow_to_convert_euros_from_euros() throws Exception {
        assertThat(EUROS.to(EUROS)).isEqualTo(BigDecimal.ONE);
    }

    @Test
    public void conversion_rate_from_euros_to_other_currencies_should_be_right() throws Exception {
        assertThat(EUROS.to(DINAR).toString()).isEqualTo("0.00072");
        assertThat(EUROS.to(WONS).toString()).isEqualTo("0.00075");
        assertThat(EUROS.to(FORINTS).toString()).isEqualTo("0.0033");
        assertThat(EUROS.to(PENCES).toString()).isEqualTo("0.0109");
        assertThat(EUROS.to(HONG_KONG_DOLLARS).toString()).isEqualTo("0.11");
        assertThat(EUROS.to(CZECK_KORUNAS).toString()).isEqualTo("0.03831");
        assertThat(EUROS.to(DOLLARS).toString()).isEqualTo("0.84");
        assertThat(EUROS.to(YENS).toString()).isEqualTo("0.0076");
        assertThat(EUROS.to(EUROS).toString()).isEqualTo("1");
    }
}