package fr.money;

import org.junit.Before;
import org.junit.Test;

import static fr.money.Currency.DOLLARS;
import static fr.money.Currency.EUROS;
import static fr.money.Currency.POUND;
import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest {
    private Wallet wallet;

    @Before
    public void setUp() throws Exception {
        wallet = new Wallet();
    }

    @Test
    public void wallet_should_be_empty_by_default() throws Exception {
        final Amount expectedAmount = new Amount(0);
        final Money expectedMoney = new Money(expectedAmount, EUROS);
        assertThat(wallet.valueIn(EUROS)).isEqualTo(expectedMoney);
    }

    @Test
    public void putting_zero_amount_in_the_wallet_should_not_update_the_value() throws Exception {
        final Amount zeroAmount = new Amount(0);
        final Money zeroMoney = new Money(zeroAmount, EUROS);

        wallet.put(zeroMoney);

        assertThat(wallet.valueIn(EUROS)).isEqualTo(zeroMoney);
    }

    @Test
    public void putting_ten_euros_in_the_wallet_should_update_the_value() throws Exception {
        final Amount ten = new Amount(10);
        final Money tenEuros = new Money(ten, EUROS);

        wallet.put(tenEuros);

        assertThat(wallet.valueIn(EUROS)).isEqualTo(tenEuros);
    }

    @Test
    public void putting_ten_euros_twice_in_the_wallet_should_update_the_value() throws Exception {
        final Amount ten = new Amount(10);
        final Money tenEuros = new Money(ten, EUROS);

        wallet.put(tenEuros);
        wallet.put(tenEuros);

        Money twentyEuros = new Money(new Amount(20), EUROS);
        assertThat(wallet.valueIn(EUROS)).isEqualTo(twentyEuros);
    }

    @Test
    public void putting_two_monies_with_different_currencies_should_update_the_value() throws Exception {
        final Money ninetyOnePounds = new Money(new Amount(91), POUND);

        wallet.put(ninetyOnePounds);

        Money oneHundredTwentyDollars = new Money(new Amount(120), DOLLARS);
        assertThat(wallet.valueIn(DOLLARS)).isEqualTo(oneHundredTwentyDollars);
    }
}