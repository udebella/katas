package kata.coffee.machine;

import java.util.Optional;

public class ExtraHot implements Drink {
    private final Drink drink;

    public ExtraHot(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String format() {
        return drink.format() + "h";
    }

    @Override
    public Optional<Amount> isMoreExpensiveThan(Amount amount) {
        return drink.isMoreExpensiveThan(amount);
    }
}
