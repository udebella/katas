package fr.money;

public class Wallet {
    private Money money = new Money(new Amount(0), Currency.EUROS);

    public void put(Money money) {
        this.money = money;
    }

    public Money valueIn(Currency currency) {
        return money;
    }
}
