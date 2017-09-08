package fr.money;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyTest {
    @Test
    public void should_allow_to_convert_euros_from_euros() throws Exception {
        assertThat(Currency.EUROS.to(Currency.EUROS)).isEqualTo(BigDecimal.ONE);
    }

    @Test
    public void should_allow_to_convert_from_euros_to_dollars() throws Exception {
        final BigDecimal eurosToDollars = new BigDecimal(84).divide(new BigDecimal(100));

        assertThat(Currency.EUROS.to(Currency.DOLLARS)).isEqualTo(eurosToDollars);
    }
}