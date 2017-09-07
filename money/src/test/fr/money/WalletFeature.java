package fr.money;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static fr.money.Currency.*;

public class WalletFeature {
    @Test
    public void putting_multiple_currency_into_my_wallet() throws Exception {
        Wallet wallet = new Wallet();

        // banknotes
        wallet.put(new Money(new Amount(50), DINAR));
        wallet.put(new Money(new Amount(1000), WONS));
        wallet.put(new Money(new Amount(10000), FORINTS));

        // coins
        wallet.put(new Money(new Amount(170), WONS));
        wallet.put(new Money(new Amount(10), FORINTS));
        wallet.put(new Money(new Amount(25), PENCES));
        wallet.put(new Money(new Amount(10).cents(), HONG_KONG_DOLLARS));
        wallet.put(new Money(new Amount(2), CZECK_KORUNAS));
        wallet.put(new Money(new Amount(11).cents(), DOLLARS));
        wallet.put(new Money(new Amount(11), YENS));
        wallet.put(new Money(new Amount(5).cents(), EUROS));

        Assertions.assertThat(wallet.value()).isEqualTo(new Money(new Amount(3453).cents(), EUROS));
    }
}
