package fr.money;

public class Money {
    private final Amount amount;
    private final Currency currency;

    public Money(Amount amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money to(Currency currency) {
        final Rate conversionRate = this.currency.to(currency);
        final Amount newAmount = amount.apply(conversionRate);
        return new Money(newAmount, currency);
    }

    public Money add(Money money) {
        final Money moneyWithSameCurrency = money.to(this.currency);
        return new Money(amount.add(moneyWithSameCurrency.amount), this.currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (!amount.equals(money.amount)) return false;
        return currency == money.currency;
    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
