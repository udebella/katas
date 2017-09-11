package fr.money;

import org.junit.Test;

import static fr.money.Currency.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void should_allow_to_create_money_from_amount_and_currency() throws Exception {
        final Amount amount = new Amount(0);
        final Money money = new Money(amount, EUROS);

        assertThat(money).isNotNull();
    }

    @Test
    public void money_can_be_compared_based_on_the_amount() throws Exception {
        final Amount amount = new Amount(0);
        final Money money1 = new Money(amount, EUROS);
        final Money money2 = new Money(amount, EUROS);

        assertThat(money1).isEqualTo(money2);
    }

    @Test
    public void money_can_be_compared_based_on_the_currency() throws Exception {
        final Amount amount = new Amount(0);
        final Money money1 = new Money(amount, EUROS);
        final Money money2 = new Money(amount, DINAR);

        assertThat(money1).isNotEqualTo(money2);
    }

    @Test
    public void money_can_be_converted_to_another_currency() throws Exception {
        final Amount amount = new Amount(0);
        final Money money1 = new Money(amount, EUROS);
        final Money money2 = new Money(amount, DINAR);

        assertThat(money1.to(DINAR)).isEqualTo(money2);
    }

    @Test
    public void convert_to_same_money_should_return_initial_money() throws Exception {
        final Amount amount = new Amount(10);
        final Money money = new Money(amount, EUROS);

        assertThat(money.to(EUROS)).isEqualTo(money);
    }
}