package fr.money;

import org.junit.Test;

import java.math.BigDecimal;

import static fr.money.Currency.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyTest {
    @Test
    public void should_allow_to_convert_euros_from_euros() throws Exception {
        assertThat(EUROS.to(EUROS)).isEqualTo(new Rate(1));
    }

    @Test
    public void should_be_able_to_convert_from_one_currency_to_euros() throws Exception {
        assertThat(EUROS.to(WONS)).isEqualTo(new Rate(new BigDecimal(136216).divide(new BigDecimal(100))));
    }

    @Test
    public void conversion_rate_from_euros_to_other_currencies_should_be_right() throws Exception {
        assertThat(DINAR.to(EUROS)).isEqualTo(new Rate(new BigDecimal(7135569l).divide(new BigDecimal(10000000000l))));
        assertThat(WONS.to(EUROS)).isEqualTo(new Rate(new BigDecimal(7341282l).divide(new BigDecimal(10000000000l))));
        assertThat(FORINTS.to(EUROS)).isEqualTo(new Rate(new BigDecimal(32611532l).divide(new BigDecimal(10000000000l))));
        assertThat(POUND.to(EUROS)).isEqualTo(new Rate(new BigDecimal(10989010990l).divide(new BigDecimal(10000000000l))));
        assertThat(HONG_KONG_DOLLARS.to(EUROS)).isEqualTo(new Rate(new BigDecimal(1063829788l).divide(new BigDecimal(10000000000l))));
        assertThat(CZECK_KORUNAS.to(EUROS)).isEqualTo(new Rate(new BigDecimal(383141763l).divide(new BigDecimal(10000000000l))));
        assertThat(DOLLARS.to(EUROS)).isEqualTo(new Rate(new BigDecimal(8333333334l).divide(new BigDecimal(10000000000l))));
        assertThat(YENS.to(EUROS)).isEqualTo(new Rate(new BigDecimal(77089116l).divide(new BigDecimal(10000000000l))));
        assertThat(EUROS.to(EUROS)).isEqualTo(new Rate(new BigDecimal(1)));
    }
}