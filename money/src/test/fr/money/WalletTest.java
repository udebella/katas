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
}