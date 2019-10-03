package kata.coffee.machine;

import kata.coffee.machine.drinks.Drink;
import kata.coffee.machine.reporting.Repository;

public class Order {
    private final Drink drink;
    private final Amount amount;

    public Order(Drink drink, Amount amount) {
        this.drink = drink;
        this.amount = amount;
    }

    public String format() {
        return amount.isEnoughFor(drink)
                .map(missingAmount -> "M:Missing " + missingAmount.format())
                .orElse(drink.format());
    }

    public void register(Repository repository) {
        if (!amount.isEnoughFor(drink).isPresent()) {
            drink.register(repository);
        }
    }

}
