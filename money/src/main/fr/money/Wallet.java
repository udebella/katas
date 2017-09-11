package fr.money;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private List<Money> monies = new ArrayList<>();

    public void put(Money money) {
        monies.add(money);
    }

    public Money valueIn(Currency currency) {
        return monies.stream()
                .reduce(new Money(new Amount(0), currency), Money::add);
    }
}
