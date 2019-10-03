package kata.coffee.machine;

import java.util.Optional;

public class Amount {
    public static final Amount ZERO = new Amount(0);
    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public Optional<Amount> isEnoughFor(Drink drink) {
        if (amount - drink.getPrice() > 0) {
            return Optional.empty();
        }
        return Optional.of(Amount.of(drink.getPrice() - amount));
    }

    public static Amount of(int amount) {
        if (amount < 0) {
            return ZERO;
        }
        return new Amount(amount);
    }

    public String format() {
        return String.valueOf(amount) + " cents";
    }
}
