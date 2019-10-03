package kata.coffee.machine;

import java.util.Optional;

public class Order {
    private final Drink drink;
    private final SugarNumber nbSugar;
    private final Amount amount;

    private Order(Drink drink, SugarNumber nbSugar, Amount amount) {
        this.drink = drink;
        this.nbSugar = nbSugar;
        this.amount = amount;
    }

    public static Order of(Drink drink, SugarNumber nbSugar, Amount amount) {
        return new Order(drink, nbSugar, amount);
    }

    public String format() {
        return amount.isEnoughFor(drink)
                .map(missingAmount -> "M:Missing " + missingAmount.format())
                .orElse(drink.format() + ":" + nbSugar.format());
    }
}
