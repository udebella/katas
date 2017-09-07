package fr.money;

import org.junit.Before;
import org.junit.Test;

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
        final Money expectedMoney = new Money(expectedAmount, Currency.EUROS);
        assertThat(wallet.valueIn(Currency.EUROS)).isEqualTo(expectedMoney);
    }

    @Test
    public void putting_zero_amount_in_the_wallet_should_not_update_the_value() throws Exception {
        final Amount zeroAmount = new Amount(0);
        final Money zeroMoney = new Money(zeroAmount, Currency.EUROS);

        wallet.put(zeroMoney);

        assertThat(wallet.valueIn(Currency.EUROS)).isEqualTo(zeroMoney);
    }
}