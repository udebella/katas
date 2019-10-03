package kata.coffee.machine.drinks;

import kata.coffee.machine.Amount;
import kata.coffee.machine.Repository;
import kata.coffee.machine.drinks.Drink;

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

    @Override
    public void register(Repository repository) {
        drink.register(repository);
    }
}
