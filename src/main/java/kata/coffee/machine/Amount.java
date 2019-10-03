package kata.coffee.machine;

import java.util.Optional;

public class Amount {
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
        return new Amount(amount);
    }

    public String format() {
        return amount + " cents";
    }
}
