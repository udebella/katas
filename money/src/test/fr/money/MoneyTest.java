package fr.money;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MoneyTest {

    @Test
    public void should_allow_to_create_money_from_amount_and_currency() throws Exception {
        Assertions.assertThat(new Money(new Amount(0), Currency.EUROS)).isNotNull();
    }
}