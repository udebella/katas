package fr.money;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

public class CurrencyTest {
    @Test
    public void should_allow_to_convert_euros_from_euros() throws Exception {
        Assertions.assertThat(Currency.EUROS.to(Currency.EUROS)).isEqualTo(BigDecimal.ONE);
    }
}