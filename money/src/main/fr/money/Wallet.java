package fr.money;

public class Wallet {
    public void put(Money money) {
    }

    public Money valueIn(Currency currency) {
        return new Money(new Amount(0), currency);
    }
}
