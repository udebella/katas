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

    @Test
    public void convert_to_another_currency_should_update_the_value() throws Exception {
        final Amount amount = new Amount(100);
        final Money money = new Money(amount, EUROS);

        assertThat(money.to(DOLLARS)).isEqualTo(new Money(new Amount(120), DOLLARS));
    }

    @Test
    public void should_be_able_to_add_same_money() throws Exception {
        final Money zeroMoney = new Money(new Amount(0), EUROS);

        final Money addResult = zeroMoney.add(zeroMoney);

        assertThat(addResult).isEqualTo(zeroMoney);
    }

    @Test
    public void should_be_able_to_add_money_with_same_currency() throws Exception {
        final Money fiveEuros = new Money(new Amount(5), EUROS);
        final Money tenEuros = new Money(new Amount(10), EUROS);

        final Money addResult = tenEuros.add(fiveEuros);

        Money fifteenEuros = new Money(new Amount(15), EUROS);
        assertThat(addResult).isEqualTo(fifteenEuros);
    }
}