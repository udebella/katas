package fr.money;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Wallet {
    public void put(Money money) {
        throw new NotImplementedException();
    }

    public Money valueIn(Currency currency) {
        return new Money(new Amount(0), currency);
    }
}
