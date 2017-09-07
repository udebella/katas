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

    @Test
    public void money_can_be_compared_based_on_the_amount() throws Exception {
        final Amount amount = new Amount(0);
        final Money money1 = new Money(amount, Currency.EUROS);
        final Money money2 = new Money(amount, Currency.EUROS);

        assertThat(money1).isEqualTo(money2);
    }

    @Test
    public void money_can_be_compared_based_on_the_currency() throws Exception {
        final Amount amount = new Amount(0);
        final Money money1 = new Money(amount, Currency.EUROS);
        final Money money2 = new Money(amount, Currency.DINAR);

        assertThat(money1).isNotEqualTo(money2);
    }
}