package kata.coffee.machine;

import java.util.Optional;

public class Amount {
    private final int value;

    private Amount(int value) {
        this.value = value;
    }

    public Optional<Amount> isEnoughFor(Drink drink) {
        return drink.isMoreExpensiveThan(this);
    }

    public Optional<Amount> isEnoughFor(Amount amount) {
        if (value - amount.value > 0) {
            return Optional.empty();
        }
        return Optional.of(Amount.of(amount.value - value));
    }

    public Amount add(Amount amount) {
        return new Amount(value + amount.value);
    }

    public static Amount of(int amount) {
        return new Amount(amount);
    }

    public String format() {
        return value + " cents";
    }
}
