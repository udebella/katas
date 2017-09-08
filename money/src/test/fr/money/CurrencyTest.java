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
    public void should_be_able_to_convert_from_one_currency_to_euros() throws Exception {
        assertThat(EUROS.to(WONS).toString()).isEqualTo("1362.16");
    }

    @Test
    public void conversion_rate_from_euros_to_other_currencies_should_be_right() throws Exception {
        assertThat(DINAR.to(EUROS).toString()).isEqualTo("0.0007135569");
        assertThat(WONS.to(EUROS).toString()).isEqualTo("0.0007341282");
        assertThat(FORINTS.to(EUROS).toString()).isEqualTo("0.0032611532");
        assertThat(POUND.to(EUROS).toString()).isEqualTo("1.098901099");
        assertThat(HONG_KONG_DOLLARS.to(EUROS).toString()).isEqualTo("0.1063829788");
        assertThat(CZECK_KORUNAS.to(EUROS).toString()).isEqualTo("0.0383141763");
        assertThat(DOLLARS.to(EUROS).toString()).isEqualTo("0.8333333334");
        assertThat(YENS.to(EUROS).toString()).isEqualTo("0.0077089116");
        assertThat(EUROS.to(EUROS).toString()).isEqualTo("1");
    }
}