package fr.money;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void should_allow_to_create_money_from_amount_and_currency() throws Exception {
        final Amount amount = new Amount(0);
        final Money money = new Money(amount, Currency.EUROS);

        assertThat(money).isNotNull();
    }
}